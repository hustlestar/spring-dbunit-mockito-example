package com.hustlestar.airbnb.service;

import com.hustlestar.airbnb.domain.Apartment;

import java.util.List;

/**
 * Created by Yauheni_Malashchytsk on 4/3/2017.
 */
public interface ApartmentService {

    List<Apartment> getAvailableApartments();

    List<Apartment> getApartmentByCriteria(String... params);

    List<Apartment> findApartment(String title);

}
