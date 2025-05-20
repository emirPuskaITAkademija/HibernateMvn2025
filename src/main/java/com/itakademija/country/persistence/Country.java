package com.itakademija.country.persistence;

import java.sql.Timestamp;
import java.util.StringJoiner;

public class Country {

    private Integer countryId;

    private String country;

    private Timestamp lastUpdate;

    public Country() {
    }

    public Country(Integer countryId, String country, Timestamp lastUpdate) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Country.class.getSimpleName() + "[", "]")
                .add("countryId=" + countryId)
                .add("country='" + country + "'")
                .add("lastUpdate=" + lastUpdate)
                .toString();
    }
}
