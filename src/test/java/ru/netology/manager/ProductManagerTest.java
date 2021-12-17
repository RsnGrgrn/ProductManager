package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ProductManagerTest {

    ProductRepository repository = Mockito.mock(ProductRepository.class);
    ProductManager manager = new ProductManager(repository);

    Smartphone iphone11 = new Smartphone(1, "IPhone 11", 45000, "Apple");
    Smartphone iphone12 = new Smartphone(2, "IPhone 12", 58000, "Apple");
    Smartphone iphone13 = new Smartphone(3, "IPhone 13", 75000, "Apple");
    Smartphone samsungS20 = new Smartphone(4, "Samsung S20", 60000, "Samsung");
    Smartphone samsungS21 = new Smartphone(5, "Samsung S21", 75000, "Samsung");

    Book book1 = new Book(1, "Спектр", 800, "Сергей Лукьяненко");
    Book book2 = new Book(2, "Ночной дозор", 850, "Сергей Лукьяненко");
    Book book3 = new Book(3, "Дневной дозор", 830, "Сергей Лукьяненко");
    Book book4 = new Book(4, "Будущее", 750, "Дмитрий Глуховский");
    Book book5 = new Book(5, "Сумерки", 780, "Дмитрий Глуховский");

    @Test
    void shouldPhoneSearchName() {
        Product[] returned = {samsungS20, samsungS21};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {samsungS20, samsungS21};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldPhoneSearchCompany() {
        Product[] returned = {iphone11, iphone12, iphone13};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {iphone11, iphone12, iphone13};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldPhoneFalseSearch() {
        Product[] returned = {iphone11, iphone12, iphone13};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("Смартфон");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldBookSearchName() {
        Product[] returned = {book2, book3};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy("дозор");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldBookSearchAuthor() {
        Product[] returned = {book1, book2, book3};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Сергей Лукьяненко");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldBookFalseSearch() {
        Product[] returned = {book1, book5, book4};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("Книга");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldSearchEmpty() {
        Product[] returned = {};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}