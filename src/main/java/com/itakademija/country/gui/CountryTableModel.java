package com.itakademija.country.gui;

import com.itakademija.country.gui.action.ActionColumnModel;
import com.itakademija.country.persistence.Country;
import com.itakademija.country.persistence.CountryDao;

import javax.swing.table.AbstractTableModel;
import java.sql.Timestamp;
import java.util.List;


//JTable <-> CountryTableModel <-> CountryDao <-> Country=country
public class CountryTableModel extends AbstractTableModel {
    private final CountryDao countryDao = new CountryDao();

    private final List<String> columnNames;
    private final List<Country> countries;

    public CountryTableModel() {
        this.columnNames = List.of("Country ID", "Country", "Last Update");
        this.countries = countryDao.getAll();
    }

    @Override
    public int getRowCount() {
        return countries.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Country country = countries.get(rowIndex);
        String columnName = columnNames.get(columnIndex);
        return switch (columnName) {
            case "Country ID" -> new ActionColumnModel(country);
            case "Country" -> country.getCountry();
            case "Last Update" -> country.getLastUpdate();
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
        //uzimamo red s kojim je povezana ćelija nad kojom radimo intervenciju
        Country rowModel = countries.get(rowIndex);
        //uzimamo kolonu s kojom je povezana ćelija
        String columnName = columnNames.get(columnIndex);
        switch (columnName) {
            case "Country ID" -> rowModel.setCountryId(((ActionColumnModel) newValue).getId());
            case "Country" -> rowModel.setCountry((String)newValue);
            case "Last Update" -> rowModel.setLastUpdate((Timestamp) newValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
        countryDao.update(rowModel);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        String columnName = columnNames.get(columnIndex);
        return switch (columnName) {
            case "Country ID" ->  ActionColumnModel.class;
            case "Country" -> String.class;
            case "Last Update" -> Timestamp.class;
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }


    public void addNewCountry(Country country) {
        countries.add(country);
        fireTableDataChanged();//refresh
        countryDao.save(country);
    }

    public void editExistingCountry(Country country) {
        int indexOfPlayer = countries.indexOf(country);
        countries.set(indexOfPlayer, country);
        fireTableDataChanged();
        countryDao.update(country);
    }

    public void deleteExistingCountry(Country country) {
        countries.remove(country);
        fireTableDataChanged();
        countryDao.delete(country);
    }
}