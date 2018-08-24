package com.courtalon.thirdBootForm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.courtalon.thirdBootForm.metier.Article;

@RestResource
public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {

}
