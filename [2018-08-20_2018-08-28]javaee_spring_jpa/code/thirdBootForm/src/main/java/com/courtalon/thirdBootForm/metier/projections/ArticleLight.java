package com.courtalon.thirdBootForm.metier.projections;

import org.springframework.data.rest.core.config.Projection;

import com.courtalon.thirdBootForm.metier.Article;

@Projection(name="ArticleLight", types=Article.class)
public interface ArticleLight {
	int getId();
	String getNom();
	String getMarque();
}
