package com.spring.democourse.repositories;

import com.spring.democourse.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
