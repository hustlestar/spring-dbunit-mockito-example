package com.hustlestar.airbnb.dao;

import com.hustlestar.airbnb.domain.Apartment;

import java.util.List;

/**
 * Created by Yauheni_Malashchytsk on 4/4/2017.
 */
public interface ApartmentDAO {

    List<Apartment> getAvailableApartments();

    List<Apartment> getApartmentByCriteria(String... params);

    List<Apartment> findApartment(String title);
}
