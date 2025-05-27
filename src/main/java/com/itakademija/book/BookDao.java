package com.itakademija.book;

import com.itakademija.Dao;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.function.Function;

public class BookDao implements Dao<Book, Long> {
    @Override
    public List<Book> getAll() {
        Function<Session, List<Book>> getAllBooksFunction = session ->{
          Query<Book> query = session.createQuery("from Book", Book.class);
          return query.list();
        };
        return executeInTransaction(getAllBooksFunction);
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void update(Book book) {

    }
}
