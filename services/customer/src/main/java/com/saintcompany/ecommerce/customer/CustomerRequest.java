package com.saintcompany.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest (
    String id,
    @NotNull(message = "Customer name required")
    String firstname,
    @NotNull(message = "Customer last name required")
    String lastname,
    @NotNull(message = "Customer email required")
    @Email(message = "Email is not valid")
    String email,
    Address address
) {

}
