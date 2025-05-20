package com.itakademija.country.gui;


import com.itakademija.country.persistence.Country;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CountryFormPanel extends JPanel {

    private JTextField countryNameField;

    public CountryFormPanel() {
        createFormGUI();
    }


    public void init(Country country) {
        if (country != null && country.getCountryId() != null) {
            countryNameField.setText(country.getCountry());
        }
    }

    private void createFormGUI() {
        setLayout(new GridLayout(6, 2, 10, 10));

        // Dodavanje paddinga oko cijelog panela
        setBorder(new EmptyBorder(15, 15, 15, 15));

        // First Name
        JLabel firstNameLabel = new JLabel("Country:");
        this.countryNameField = new JTextField();
        add(firstNameLabel);
        add(countryNameField);
    }

    public String getCountry() {
        return this.countryNameField.getText();
    }
}


