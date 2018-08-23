package com.courtalon.firstspringbootForm.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//indique a spring que cette classe est un controller web qui répondra a des requette http
@Controller
@RequestMapping("/helloapi") // url de base de notre controlleur
public class HelloController {


	// cette methode repond a l'url '/helloapi/salutation' et uniquemnt au GET
	// elle renverra du json encodé en UTF-8 
	@RequestMapping(value="/salutation",
					method= RequestMethod.GET,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody // l'objet renvoyé devra etre retourné dans le corp de la réponse
	public Map<String, String> hello() {
		HashMap<String, String> result = new HashMap<>();
		result.put("message", "bienvenue dans spring boot mvc");
		return result;
	}
	// la librairie Jackson est intégré par défaut dans spring boot
	// c'est elle qui se chargera de convertir le retour "java" en json
	
	
	
	@RequestMapping(value="/salutation/{nom:[a-zA-Z]+}",
					method= RequestMethod.GET,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, String> helloWithName(@PathVariable("nom") String nom) {
		HashMap<String, String> result = new HashMap<>();
		result.put("message", "bonjour " + nom);
		return result;
	}
	
	
}
