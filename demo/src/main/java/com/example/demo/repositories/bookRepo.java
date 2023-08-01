package com.example.demo.repositories;

import com.example.demo.domain.book;
import org.springframework.data.repository.CrudRepository;

public interface bookRepo extends CrudRepository<book,Long> {

}
