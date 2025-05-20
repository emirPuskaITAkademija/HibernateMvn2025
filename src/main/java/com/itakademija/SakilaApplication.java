package com.itakademija;


import com.itakademija.actor.persistence.ActorDao;
import com.itakademija.country.gui.CountryTablePanel;

import javax.swing.*;

public class SakilaApplication {
    public static void main(String[] args) throws Exception {
//        UIManager.setLookAndFeel(new FlatDarkLaf());
//        Runnable worker = SakilaApplication::createAndShowGUI;
//        SwingUtilities.invokeLater(worker);

        ActorDao actorDao = new ActorDao();
        actorDao.getAll().forEach(System.out::println);
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