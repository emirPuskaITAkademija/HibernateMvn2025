package com.itakademija;


import com.itakademija.actor.persistence.Actor;
import com.itakademija.actor.persistence.ActorDao;
import com.itakademija.country.gui.CountryTablePanel;

import javax.swing.*;
import java.sql.Timestamp;

public class SakilaApplication {
    public static void main(String[] args) throws Exception {
//        UIManager.setLookAndFeel(new FlatDarkLaf());
//        Runnable worker = SakilaApplication::createAndShowGUI;
//        SwingUtilities.invokeLater(worker);

        Actor actor = new Actor();
        actor.setFirstName("Jovan");
        actor.setLastName("Carević");
        actor.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        Actor persistedActor = actor.save();//on ima metodu save()
        System.out.println(persistedActor);
//        ActorDao actorDao = new ActorDao();
//        actorDao.save(actor);
//        actorDao.getAll().forEach(System.out::println);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Country Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new CountryTablePanel();
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}