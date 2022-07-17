package com.san.tech.rent.book.serviceImpl;

import com.san.tech.rent.book.dto.BookDTO;
import com.san.tech.rent.book.dto.CustomerDTO;
import com.san.tech.rent.book.entity.Book;
import com.san.tech.rent.book.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@Primary
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final RestTemplate restTemplate;

    @Override
    public Book readBook(String id) {
        return null;
    }

    @Override
    public List<BookDTO> getBookByCustomer() {
        return null;
    }

    @Override
    public List<BookDTO> getAllBook() {
        return null;
    }

    @Override
    public void createBook(BookDTO book) {
        // todo: Get the customer
        String url = "http://localhost:8083/api/v1/customer/" + book.getCustomerId();
        log.info(url);
        CustomerDTO customer = restTemplate.getForObject(
                url,
                CustomerDTO.class
        );

        log.info(customer.toString());
        // Find the vehicle

        // Save the booking
    }
}
