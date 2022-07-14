package com.san.tech.rent.book.entity;

import com.san.tech.rent.book.dto.CustomerDTO;
import com.san.tech.rent.book.dto.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document
public class Book {
    @Id
    private long id;
    private CustomerDTO customer;
    private VehicleDTO vehicle;
    private long dateFrom;
    private long dateTo;
}
