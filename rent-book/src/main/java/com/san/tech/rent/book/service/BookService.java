package com.san.tech.rent.book.service;

import com.san.tech.rent.book.dto.BookDTO;
import com.san.tech.rent.book.entity.Book;

import java.util.List;

public interface BookService {
    Book readBook(String id);
    List<BookDTO> getBookByCustomer();
    List<BookDTO> getAllBook();
    void createBook(BookDTO book);
}
