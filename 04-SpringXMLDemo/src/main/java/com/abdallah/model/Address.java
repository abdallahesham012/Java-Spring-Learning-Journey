package com.abdallah.model;

public class Address {

    private String city;
    private String street;


    /*
        Constructor فارغ

        مهم جدًا مع Setter Injection.

        Spring هيعمل:

        new Address()

        وبعد كده يستخدم setters
        عشان يحط القيم.
    */
    public Address() {

    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {

        /*
            هنا Spring هيستدعي الـ setter
            من خلال XML.

            مثال:

            <property name="city" value="Banha"/>

            Spring داخليًا هيعمل:

            address.setCity("Banha");
        */

        this.city = city;
    }


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {

        this.street = street;
    }


    @Override
    public String toString() {

        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}