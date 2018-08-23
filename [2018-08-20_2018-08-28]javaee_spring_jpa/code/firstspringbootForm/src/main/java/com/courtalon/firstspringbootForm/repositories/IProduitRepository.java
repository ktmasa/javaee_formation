package com.courtalon.firstspringbootForm.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.courtalon.firstspringbootForm.metier.Produit;

public interface IProduitRepository {

	List<Produit> findAll();
	Produit findbyId(int id);
	Produit save(Produit p);
	void delete(int id);
}