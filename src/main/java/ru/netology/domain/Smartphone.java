package ru.netology.domain;

import lombok.Data;

import java.util.Objects;

@Data

public class Smartphone extends Product {

    private String company;

    public Smartphone(int id, String name, int price, String company) {
        super(id, name, price);
        this.company = company;
    }

    public Smartphone() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        if (!super.equals(o)) return false;
        Smartphone phone = (Smartphone) o;
        return company.equals(phone.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company);
    }
}
