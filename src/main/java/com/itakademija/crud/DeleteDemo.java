package com.itakademija.crud;

import com.itakademija.country.persistence.Country;
import com.itakademija.util.HibernateUtil;
import org.hibernate.Session;

public class DeleteDemo {
    public static void main(String[] args) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Country country = session.get(Country.class, 112);
            session.delete(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
