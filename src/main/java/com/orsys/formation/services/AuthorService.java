package com.orsys.formation.services;

import com.orsys.formation.models.AuthorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "authorservice")
public interface AuthorService {

    @RequestMapping(path = "authors/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id);

}
