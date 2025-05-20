package com.itakademija.country.persistence;


import org.hibernate.Session;

import java.util.function.Function;

public class CountryDeleteFunction implements Function<Session, Integer> {
    private final Country country;

    public CountryDeleteFunction(Country country) {
        this.country = country;
    }

    @Override
    public Integer apply(Session session) {
        session.delete(country);
        return country.getCountryId();
    }
}
