package com.itakademija.country.gui.action;


import com.itakademija.country.gui.CountryInfoFrame;
import com.itakademija.country.gui.CountryTableModel;
import com.itakademija.country.persistence.Country;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {

    private ActionColumnModel actionColumnModel;

    @Override
    public Object getCellEditorValue() {
        return actionColumnModel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.actionColumnModel = (ActionColumnModel) value;
        JPanel panel = new JPanel();
        JButton deleteButton = ActionButtonFactory.DELETE.getButton(table);
        deleteButton.addActionListener(event -> onDeleteButtonClick(event, table));

        JButton editButton = ActionButtonFactory.EDIT.getButton(table);
        editButton.addActionListener(event -> onEditButtonClick(table));

        panel.add(deleteButton);
        panel.add(editButton);

        return panel;
    }

    private void onEditButtonClick(JTable table) {
        CountryTableModel countryTableModel = (CountryTableModel) table.getModel();
        Country country = actionColumnModel.getCountry();
        CountryInfoFrame.showEditPlayerForm(country, countryTableModel::editExistingCountry);
    }

    private void onDeleteButtonClick(ActionEvent actionEvent, JTable table) {
        CountryTableModel countryTableModel = (CountryTableModel) table.getModel();
        String actionCommand = actionEvent.getActionCommand();
        System.out.println("Delete Action Triggered: " + actionCommand);

        String confirmationMessage = "Are you sure that you want to delete record with name '%s'".formatted(actionColumnModel.getFullName());
        int response = JOptionPane.showConfirmDialog(null,
                confirmationMessage,
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            Country playerInfo = actionColumnModel.getCountry();
            countryTableModel.deleteExistingCountry(playerInfo);
        } else {
            JOptionPane.showMessageDialog(null, "Player '%s' is not properly deleted".formatted(actionColumnModel.getFullName()));
        }
    }
}
