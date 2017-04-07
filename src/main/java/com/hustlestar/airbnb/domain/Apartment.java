package com.hustlestar.airbnb.domain;

/**
 * Created by Yauheni_Malashchytsk on 4/3/2017.
 */
public class Apartment extends AbstractEntity{
    private int country;
    private int city;
    private String address;
    private String title;

    public Apartment() {
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Apartment{");
        sb.append("country='").append(country).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
