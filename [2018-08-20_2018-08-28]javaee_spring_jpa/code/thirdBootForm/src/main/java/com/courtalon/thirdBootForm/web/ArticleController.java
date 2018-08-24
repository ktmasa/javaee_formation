package com.courtalon.thirdBootForm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.courtalon.thirdBootForm.metier.Article;
import com.courtalon.thirdBootForm.repositories.ArticleRepository;

@Controller
@RequestMapping("/customapi/articles")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	// comme je n'ai pas préciser d'url, il utilise celle de base du controller
	@RequestMapping(method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins= {"http://localhost:4200"}, methods= {RequestMethod.GET, RequestMethod.OPTIONS})
	public Page<Article> findAll(@PageableDefault(page=0, size=5) Pageable pr) {
		return articleRepository.findAll(pr);
	}
	
}
