package com.san.tech.rent.book.repository;

import com.san.tech.rent.book.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long> {
}
