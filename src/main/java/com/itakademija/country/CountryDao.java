package com.itakademija.country;

import com.itakademija.Dao;
import com.itakademija.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.function.Function;

public class CountryDao implements Dao<Country> {
    @Override
    public List<Country> getAll() {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            Query<Country> query = session.createQuery("from Country");
//            session.getTransaction().commit();
//            return query.list();
//        } catch (HibernateException e) {
//            System.err.println(e.getMessage());
//        }
//        return List.of();

        return executeInTransaction(session -> {
            Query<Country> query = session.createQuery("from Country");
            return query.list();
        });
    }

    @Override
    public Country getById(int id) {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            Country country = session.get(Country.class, id);
//            session.getTransaction().commit();
//            return country;
//        } catch (HibernateException e) {
//            System.err.println(e.getMessage());
//        }
//        return null;

        return executeInTransaction(session -> session.get(Country.class, id));
    }


    @Override
    public Country save(Country country) {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            int id = (int)session.save(country);
//            country.setCountryId(id);
//            session.getTransaction().commit();
//            return country;
//        } catch (HibernateException e) {
//            System.err.println(e.getMessage());
//        }
//        return null;
        return executeInTransaction(session -> {
            int id = (int) session.save(country);
            country.setCountryId(id);
            return country;
        });
    }

    @Override
    public void delete(Country country) {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.delete(country);
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            System.err.println(e.getMessage());
//        }

        executeInTransaction(session -> {
            session.delete(country);
            return null;
        });
    }

    @Override
    public void update(Country country) {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.merge(country);
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            System.err.println(e.getMessage());
//        }
        executeInTransaction(session -> session.merge(country));
    }

    //Identikuj dijelove koda koji se ne mijenjaju
    //Identifikuj zatim dijelove koda koji se mijenjaju -> izoluj ih u interface
    //  Function<Session, E> function
    private <R> R executeInTransaction(Function<Session, R> function) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            //DIO koji je promjenljiv
            R result = function.apply(session);
            //DIO koji je promjenljiv
            session.getTransaction().commit();
            return result;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
