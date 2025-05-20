package com.itakademija.country.gui.action;

import com.itakademija.country.persistence.Country;

public class ActionColumnModel {
    private Country country;

    public ActionColumnModel(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public Integer getId() {
        return country.getCountryId();
    }


    public String getFullName() {
        return country.getCountry();
    }
}
