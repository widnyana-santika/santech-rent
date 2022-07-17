package com.san.tech.rent.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookDTO {
    private String id;
    private Long customerId;
    private Long vehicleId;
    private long dateFrom;
    private long dateTo;
}
