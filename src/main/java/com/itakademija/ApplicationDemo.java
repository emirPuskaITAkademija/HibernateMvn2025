package com.itakademija;

import com.itakademija.country.Country;
import com.itakademija.country.CountryDao;

import java.util.List;

public class ApplicationDemo {
    public static void main(String[] args) {
        CountryDao countryDao = new CountryDao();
        Country country = countryDao.getById(111);
        System.out.println(country);
        country.setCountry(country.getCountry());
        countryDao.update(country);
        System.out.println(country);
        countryDao.delete(country);
    }
}
