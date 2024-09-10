package com.saincompany.ecommerce.payment;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Validated
public record Customer(
    String id,
    @NotNull(message = "First name is required")
    String firstname,
    @NotNull(message = "Last name is required")
    String lastname,
    @NotNull(message = "Email name is required")
    @Email(message = "Customer e-mail is not correctly formatted")
    String email
) {

}
