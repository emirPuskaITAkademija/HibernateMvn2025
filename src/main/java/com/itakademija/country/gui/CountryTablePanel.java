package com.itakademija.country.gui;

import com.itakademija.country.gui.action.ActionButtonFactory;
import com.itakademija.country.gui.action.ActionCellEditor;
import com.itakademija.country.gui.action.ActionCellRenderer;
import com.itakademija.country.gui.action.ActionColumnModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
//CountryTablePanel, JTable <-> CountryTableModel
public class CountryTablePanel extends JPanel {
    private final CountryTableModel playerTableModel;

    public CountryTablePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(15, 15, 15, 15));


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBorder(new EmptyBorder(0, 0, 10, 0));

        JButton addPlayerButton = ActionButtonFactory.ADD.getButton(this::openForm);
        buttonPanel.add(addPlayerButton);
        add(buttonPanel);

        // Kreiranje tabele
        this.playerTableModel = new CountryTableModel();
        JTable table = new JTable(playerTableModel);
        table.setRowHeight(40);
        table.getColumnModel().getColumn(0).setMinWidth(180);
        table.getColumnModel().getColumn(1).setMinWidth(60);
        table.getColumnModel().getColumn(2).setMinWidth(60);
        table.setFillsViewportHeight(true);


        table.setDefaultRenderer(ActionColumnModel.class, new ActionCellRenderer());
        table.setDefaultEditor(ActionColumnModel.class, new ActionCellEditor());

        // Panel za tabelu s dodatnim razmakom
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
        tablePanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        add(tablePanel);
    }

    private void openForm(ActionEvent e) {
        CountryInfoFrame.showNewCountryForm(playerTableModel::addNewCountry);
    }
}
