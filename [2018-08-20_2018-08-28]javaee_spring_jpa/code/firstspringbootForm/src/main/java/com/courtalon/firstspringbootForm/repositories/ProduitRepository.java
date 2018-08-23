package com.courtalon.firstspringbootForm.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courtalon.firstspringbootForm.metier.Produit;

@Service  // declaration d'un bean de type service
public class ProduitRepository implements IProduitRepository {

	@PersistenceContext   // injection de l'entityManager
	private EntityManager em;
	
	
	@Override
	@Transactional  // ouverture et commit automatique de la transaction
	public List<Produit> findAll() {
		return em.createQuery("from Produit", Produit.class).getResultList();
	}
	
	@Override
	@Transactional  // ouverture et commit automatique de la transaction
	public Produit findbyId(int id) {
		return em.find(Produit.class, id);
	}
	
	@Override
	@Transactional
	public Produit save(Produit p) {
		if (p.getId() == 0) {
			em.persist(p);
			return p;
		}
		else {
			return em.merge(p);
		}
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		Produit p = em.find(Produit.class, id);
		if (p != null)
			em.remove(p);
	}
	
	
}
