package com.novatec.wsdljavaclientgenerator;

import java.util.HashMap;
import java.util.Map;

import com.novatec.wsdljavaclientgenerator.client.gen.Book;
import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class BookRepository {

    private static final Map<String, Book> books = new HashMap<>();

    @PostConstruct
    public void initData() {
        Book book = new Book();
        book.setTitle("The Great Gatsby");
        book.setAuthor("F. Scott Fitzgerald");

        books.put(book.getTitle(), book);
    }

    public Book findBook(String name) {
        Assert.notNull(name, "The book's name must not be null");
        return books.get(name);
    }
}
