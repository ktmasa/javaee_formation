package com.courtalon.thirdBootForm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.courtalon.thirdBootForm.metier.ImageFile;

public interface ImageFileRepository extends PagingAndSortingRepository<ImageFile, Long> {
	
}
