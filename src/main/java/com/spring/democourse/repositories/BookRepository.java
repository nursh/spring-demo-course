package com.spring.democourse.repositories;

import com.spring.democourse.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
