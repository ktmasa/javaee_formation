package com.courtalon.firstspringbootForm.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.courtalon.firstspringbootForm.metier.Produit;
import com.courtalon.firstspringbootForm.repositories.IProduitRepository;

@Controller
@RequestMapping("/produits")
public class ProduitController {

	@Autowired
	private IProduitRepository produitRepository;
	
	
	@RequestMapping(value="/liste",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Produit> listeProduits() {
		return produitRepository.findAll();
	}

	
	@RequestMapping(value="/detail/{id:[0-9]+}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Produit detailsProduit(@PathVariable("id") int id) {
		return produitRepository.findbyId(id);
	}
	
	@RequestMapping(value="/save",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Produit saveProduit(@RequestBody Produit p) {
		return produitRepository.save(p);
	}

	@RequestMapping(value="/save",
			method=RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Produit updateProduit(@RequestBody Produit p) {
		return produitRepository.save(p);
	}
	
	@RequestMapping(value="/remove/{id:[0-9]+}",
			method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, String> removeProduit(@PathVariable("id") int id) {
		produitRepository.delete(id);
		HashMap<String, String> result = new HashMap<>();
		result.put("product_deleted_id", "" + id);
		return result;
	}
	
	
	
}
