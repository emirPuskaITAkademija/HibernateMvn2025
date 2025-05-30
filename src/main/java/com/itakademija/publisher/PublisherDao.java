package com.itakademija.publisher;

import com.itakademija.Dao;
import org.hibernate.Query;
import org.hibernate.Session;


import java.util.List;
import java.util.function.Function;

public class PublisherDao implements Dao<Publisher, Long> {
    @Override
    public List<Publisher> getAll() {
        Function<Session, List<Publisher>> fetchPublisherFunction = session -> {
            Query<Publisher> query = session.createQuery("from Publisher", Publisher.class);
            return query.getResultList();
        };
        return executeInTransaction(fetchPublisherFunction);
    }

    @Override
    public Publisher getById(Long id) {
        return null;
    }

    @Override
    public Publisher save(Publisher publisher) {
        Function<Session, Publisher> savePublisherFunction = session -> {
            session.save(publisher);
            return publisher;
        };
        return executeInTransaction(savePublisherFunction);
    }

    @Override
    public void delete(Publisher publisher) {

    }

    @Override
    public void update(Publisher publisher) {

    }
}
