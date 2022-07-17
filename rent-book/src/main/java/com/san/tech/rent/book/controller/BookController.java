package com.san.tech.rent.book.controller;

import com.san.tech.rent.book.dto.BookDTO;
import com.san.tech.rent.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/book")
@ComponentScan("com.san.tech.rent.book.serviceImpl")
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody BookDTO dto){
        service.createBook(dto);
    }
}
