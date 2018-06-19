package com.fnoc.librairie.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fnoc.librairie.metier.Livre;

public interface LivreRepository extends PagingAndSortingRepository<Livre, Integer> {

	Page<Livre> findByTitreContaining(String searchTerm, Pageable page);
}
