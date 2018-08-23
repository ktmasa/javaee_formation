package com.courtalon.secondbootForm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.courtalon.secondbootForm.metier.Client;

@RepositoryRestResource
public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

	Page<Client> findByEmailContaining(@Param("searchTerm") String searchterm, Pageable page);
	
}
