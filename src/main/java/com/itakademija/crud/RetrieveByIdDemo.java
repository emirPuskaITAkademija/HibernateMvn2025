package com.itakademija.crud;

import com.itakademija.country.Country;
import com.itakademija.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Možemo findById kreirati:
 * <li>1. load(className, PK)</li>
 * <li>2. get(className, PK)</li>
 */
public class RetrieveByIdDemo {
    public static void main(String[] args) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Country country = session.load(Country.class, 108);
            System.out.println(country);
            session.getTransaction().commit();
        }catch (Exception e){
            System.err.println("GET by ID " + e.getMessage());
        }
    }
}
