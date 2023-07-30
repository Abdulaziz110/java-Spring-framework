package com.courses.restapi.srevices;


import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EntityService<T> {

    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> findById(Long id);

    ResponseEntity<T> create(T entity);

    ResponseEntity<T> update(Long id, T updatedEntity);

    ResponseEntity<String> remove(Long id);
}

