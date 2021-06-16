package com.guru.springGuru.repositories;

import com.guru.springGuru.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
