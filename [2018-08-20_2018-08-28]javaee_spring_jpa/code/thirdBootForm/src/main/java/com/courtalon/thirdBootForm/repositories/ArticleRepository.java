package com.courtalon.thirdBootForm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.courtalon.thirdBootForm.metier.Article;

@RestResource
public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {

	public Page<Article> findByFamille_id(int id, Pageable pr);
//	public Page<Article> findBySousFamille_Famille_id(int id, Pageable pr);
}
