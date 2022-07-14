package com.san.tech.rent.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private long id;
    private String surname;
    private String email;
    private String address;
    private String phoneNumber;
}
