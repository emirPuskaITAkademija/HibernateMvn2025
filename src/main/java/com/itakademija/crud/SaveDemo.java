package com.itakademija.crud;

import com.itakademija.country.persistence.Country;
import com.itakademija.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Timestamp;

/**
 * Možemo koristiti 2 metode:
 * <li>persist JPA poznaje samo persist, ne vrati ništa..void</li>
 * <li>save vrati ID upisanog reda</li>
 */
public class SaveDemo {
    public static void main(String[] args) {
        Country country = new Country();
        country.setCountry("Monako");
        country.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            short id = (short)session.save(country);
            System.out.println("Snimljen objekat %s sa id=%s".formatted(country.getCountry(), id));
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
