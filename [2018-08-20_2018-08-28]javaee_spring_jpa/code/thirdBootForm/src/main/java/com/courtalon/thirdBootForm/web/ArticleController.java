package com.courtalon.thirdBootForm.web;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.courtalon.thirdBootForm.metier.Article;
import com.courtalon.thirdBootForm.metier.projections.ArticleLight;
import com.courtalon.thirdBootForm.repositories.ArticleRepository;

@Controller
@RequestMapping("/customapi/articles")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	private final ProjectionFactory projectionFactory;
	
	// spring nous injectera à la construction du controlleur
	// la projection factory que l'on a déclarée dans jsonConfig
	@Autowired
	public ArticleController(ProjectionFactory projectionFactory) {
		this.projectionFactory = projectionFactory;
	}

	// comme je n'ai pas préciser d'url, il utilise celle de base du controller
	@RequestMapping(method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins= {"http://localhost:4200"}, methods= {RequestMethod.GET, RequestMethod.OPTIONS})
	public Page<Article> findAll(@PageableDefault(page=0, size=5) Pageable pr) {
		return articleRepository.findAll(pr);
	}
	
	// sur l'url 'light'
	// on renverra des ArticleLight au lieu des articles complets
	@RequestMapping(
			value="/light",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins= {"http://localhost:4200"}, methods= {RequestMethod.GET, RequestMethod.OPTIONS})
	public Page<ArticleLight> findAllLight(@PageableDefault(page=0, size=5) Pageable pr){
		// Page<Article>     ---> Page<ArticleLight>
		// Page<Article>  --> Page , articles
		// pr -> noPage, taillePage
		// page.totalElements -> nombre total de lignes (necessaire pour la pagination)
		// new PageImpl( contenu, infoPages, nombretotaldelignes)
		// contenu -> transformation de List<Article> -> liste<ArticleLight>
		// stream -> pour chaque article, applique la projection vers ArticleLight
		//			-> enfin, recupérer tous les articleLight dans une List
		// renvoyer la nouvelle page avec les articleLight
		
		Page<Article> page = articleRepository.findAll(pr);
		Page<ArticleLight> pageLight = new PageImpl<>(
				page.getContent().stream().map(
						art -> projectionFactory.createProjection(ArticleLight.class, art))
								.collect(Collectors.toList()),
				pr,
				page.getTotalElements());
		return pageLight;
		
	}
}
