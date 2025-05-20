package com.itakademija.crud;

import com.itakademija.country.Country;
import com.itakademija.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Postoje 2 funkcije
 * <li> 1. update -> mora uvijek raditi sa svježom instancom...
 *  Bili smo na sesiji pa se otkačili, a u prethodno sesiji smo dohvatili instancu a onda otvorili
 *  novu sesiju i u novoj sesiji ne možemo snimiti prethodno dohvaćeni objekat
 * </li>
 * <li> 2. merge -> može čini mi se raditi i sa "otkačenim" objektom ili english detached  </li>
 */
public class UpdateDemo {

    public static void main(String[] args) {
        try{
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            session1.beginTransaction();
            Country country1 = session1.load(Country.class, 108);
            session1.getTransaction().commit();
            country1.setCountry("Bivša Yugoslavia");
            Session session2 = HibernateUtil.getSessionFactory().openSession();
            session2.beginTransaction();
            session2.merge(country1);
            session2.getTransaction().commit();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
        }
    }
}
