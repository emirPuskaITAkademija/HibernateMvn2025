package com.itakademija.country.gui;


import com.itakademija.country.persistence.Country;
import com.itakademija.util.IconLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class CountryInfoFrame extends JFrame {
    private final IconLoader iconLoader = new IconLoader(CountryInfoFrame.class);

    private final Country country;
    private final CountryFormPanel countryFormPanel;
    private final Consumer<Country> countryConsumer;

    //ADD NEW PLAYER
    private CountryInfoFrame(Consumer<Country> countryConsumer) {
        this(new Country(), countryConsumer);
    }

    //EDIT
    private CountryInfoFrame(Country country, Consumer<Country> countryConsumer) {
        super("Country Form");
        this.country = country;
        this.countryConsumer = countryConsumer;
        this.countryFormPanel = new CountryFormPanel();
        this.countryFormPanel.init(country);
        createFormUI();
    }

    private void createFormUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 300);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Icon saveIcon = iconLoader.loadIcon("player/save-icon16x16.png");
        JButton saveButton = new JButton("SAVE", saveIcon);
        saveButton.addActionListener(this::onSaveButtonClick);
        JButton cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(cancelEvent -> dispose());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(countryFormPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void onSaveButtonClick(ActionEvent event) {
        country.setCountry(countryFormPanel.getCountry());
        JOptionPane.showMessageDialog(this, "Data saved successfully!", "Save", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        countryConsumer.accept(country);
    }

    public static void showNewCountryForm(Consumer<Country> addNewCountryConsumer) {
        CountryInfoFrame countryInfoFrame = new CountryInfoFrame(addNewCountryConsumer);
        countryInfoFrame.setVisible(true);
    }

    public static void showEditPlayerForm(Country country, Consumer<Country> countryConsumer) {
        CountryInfoFrame countryInfoFrame = new CountryInfoFrame(country, countryConsumer);
        countryInfoFrame.setVisible(true);
    }
}
