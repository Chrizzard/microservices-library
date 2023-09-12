package com.createment.microserviceslibrary.book;

import lombok.Data;

import java.util.Objects;

@Data
public class Customer {
    private Long id;
    private String name;
    private String address;
    private String phonenumber;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(address, customer.address) && Objects.equals(phonenumber, customer.phonenumber) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phonenumber, email);
    }
}
