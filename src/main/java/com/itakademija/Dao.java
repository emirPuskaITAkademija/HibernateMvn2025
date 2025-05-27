package com.itakademija;

import com.itakademija.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.function.Function;

public interface Dao<E, PK> {

    List<E> getAll();

    E getById(PK id);

    E save(E e);

    void delete(E e);

    void update(E e);

    default <R>  R executeInTransaction(Function<Session, R> function) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            R result = function.apply(session);
            session.getTransaction().commit();
            return result;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
