package com.guru.springGuru.repositories;

import com.guru.springGuru.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
