package com.itakademija.country.persistence;

import com.itakademija.Dao;
import org.hibernate.Query;

import java.util.List;

public class CountryDao implements Dao<Country, Integer> {
    @Override
    public List<Country> getAll() {
        return executeInTransaction(session -> {
            Query<Country> query = session.createQuery("from Country");
            return query.list();
        });
    }

    @Override
    public Country getById(Integer id) {
        return executeInTransaction(session -> session.get(Country.class, id));
    }


    @Override
    public Country save(Country country) {
        return executeInTransaction(session -> {
            int id = (int) session.save(country);
            country.setCountryId(id);
            return country;
        });
    }

    @Override
    public void delete(Country country) {
        executeInTransaction(new CountryDeleteFunction(country));

//        executeInTransaction(session -> {
//            session.delete(country);
//            return country.getCountryId();
//        });
    }

    @Override
    public void update(Country country) {
        executeInTransaction(session -> session.merge(country));
    }
}
