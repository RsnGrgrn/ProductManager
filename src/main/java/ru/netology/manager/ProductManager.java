package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(Product item) {
        repository.save(item);
    }

    public void findAll() {
        repository.findAll();
    }


}