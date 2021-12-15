package ru.netology.ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

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