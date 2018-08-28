package com.courtalon.jspbootform.web;

import java.time.LocalDateTime;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class HomeController {

	/*
	 * dans un controleur "non rest"
	 * si le retour est une chaine de caractere, spring assume 
	 * qu'il s'agit du nom de la vue à utiliser pour générer le html
	 * dans notre cas, la page jsp
	 */	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "home"; 
	}
	
	@RequestMapping(value="/bonjour", method=RequestMethod.GET)
	public ModelAndView index2() {
		ModelAndView mv = new ModelAndView("bonjour");
		mv.addObject("message", "bonjour, nous somme le " + LocalDateTime.now());
		return mv;
	}

	// methode pour tester sécurité
//	@Secured(value="has_role(....)")
	@RequestMapping(value="/admin/index", method=RequestMethod.GET)
	public ModelAndView indexAdmin() {
		ModelAndView mv = new ModelAndView("bonjour");
		mv.addObject("message", "bonjour, vous etes dans la zone admin");
		return mv;
	}

	@RequestMapping(value="/user/index", method=RequestMethod.GET)
	public ModelAndView indexUser() {
		ModelAndView mv = new ModelAndView("bonjour");
		mv.addObject("message", "bonjour, vous etes dans la zone user");
		return mv;
	}

	
}
