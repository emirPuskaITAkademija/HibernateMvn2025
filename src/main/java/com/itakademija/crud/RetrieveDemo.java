package com.itakademija.crud;

import com.itakademija.country.Country;
import org.hibernate.*;
import org.hibernate.query.Query;
import com.itakademija.util.HibernateUtil;

import java.util.List;

public class RetrieveDemo {

    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            //transakciono - početi transakciju
            Transaction transaction = session.getTransaction();
            transaction.begin();
            //select * from country;
            Query<Country> query = session.createQuery("from Country");
            List<Country> list = query.list();
            for(Country country : list) {
                System.out.println(country);
            }
            transaction.commit();
            //potvrdi transakciju
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
    }
}
