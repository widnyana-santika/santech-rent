package com.san.tech.rent.customer.entity;

import com.san.tech.rent.type.Gender;
import lombok.*;

import javax.persistence.*;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private long id;
    private String surname;
    private String email;
    private Gender gender;
    private String address;
    private Long phoneNumber;
}
