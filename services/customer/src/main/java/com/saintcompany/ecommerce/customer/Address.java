package com.saintcompany.ecommerce.customer;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
