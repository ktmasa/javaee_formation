package com.fnoc.librairie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fnoc.librairie.metier.Livre;
import com.fnoc.librairie.repositories.LivreRepository;

@Controller
@RequestMapping("/custom/livres")
public class LivreController {

	@Autowired
	private LivreRepository livreRepository;
	
	@RequestMapping(value="/search/{searchterm:[a-zA-Z0-9]+}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Livre> liste(@PathVariable("searchterm") String searchTerm) {
		return livreRepository.findByTitreContaining(searchTerm, new PageRequest(0, 10));
	}
	
}
