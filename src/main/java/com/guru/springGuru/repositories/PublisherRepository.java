package com.guru.springGuru.repositories;

import com.guru.springGuru.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
