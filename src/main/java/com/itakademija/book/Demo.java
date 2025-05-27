package com.itakademija.book;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.getAll();
        books.forEach(System.out::println);
    }
}
