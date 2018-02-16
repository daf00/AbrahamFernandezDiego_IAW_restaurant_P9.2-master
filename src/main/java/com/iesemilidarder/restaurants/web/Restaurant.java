package com.iesemilidarder.restaurants.web;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String RES_NOM;
    private String RES_ADRECA;
    private String RES_WEB;
    private String RES_CODI;
    private String RES_TELEFON;
    private String TRS_DESCRIPCIO;
    private String RES_URL_IMG;
    private String RES_MITJANA;
    private String RES_LATITUD;
    private String RES_LONGITUD;

    private List<Restaurant_Opinions> aL_Opi;

    public Restaurant() {
        super();
        this.aL_Opi = new ArrayList<Restaurant_Opinions>();
    }

    //  Setters
    public void setRestaurant_name(String restaurant_name) {
        this.RES_NOM = restaurant_name;
    }

    public void setRestaurant_adreca(String restaurant_adreca) {
        this.RES_ADRECA = restaurant_adreca;
    }

    public void setRestaurant_web(String restaurant_web) {
        this.RES_WEB = restaurant_web;
    }

    public void setRestaurant_telefon(String restaurant_telefon) {
        this.RES_TELEFON = restaurant_telefon;
    }

    public void setRestaurant_descripcio(String restaurant_descripcio) {
        this.TRS_DESCRIPCIO = restaurant_descripcio;
    }

    public void setRestaurant_imatge(String RES_URL_IMG) {
        this.RES_URL_IMG = RES_URL_IMG;
    }

    public void setRestaurant_mitjana(String RES_MITJANA) {
        this.RES_MITJANA = RES_MITJANA;
    }

    public void setRestaurant_codi(String RES_CODI) {
        this.RES_CODI = RES_CODI;
    }

    public void setRestaurant_LATITUD(String RES_LATITUD) {
        this.RES_LATITUD = RES_LATITUD;
    }

    public void setRestaurant_LONGITUD(String RES_LONGITUD) {
        this.RES_LONGITUD = RES_LONGITUD;
    }

    public void setaL_Opi(List<Restaurant_Opinions> aL_Opi) {
        this.aL_Opi = aL_Opi;
    }

    //  Getters
    public String getRestaurant_name() {
        return RES_NOM;
    }

    public String getRestaurant_adreca() {
        return RES_ADRECA;
    }

    public String getRestaurant_web() {
        return RES_WEB;
    }

    public String getRestaurant_telefon() {
        return RES_TELEFON;
    }

    public String getRestaurant_descripcio() {
        return TRS_DESCRIPCIO;
    }

    public String getRestaurant_imatge() {
        return RES_URL_IMG;
    }

    public String getRestaurant_mitjana() {
        return RES_MITJANA;
    }

    public String getRestaurant_codi() {
        return RES_CODI;
    }

    public String getRestaurant_LATITUD() {
        return RES_LATITUD;
    }

    public String getRestaurant_LONGITUD() {
        return RES_LONGITUD;
    }

    public List<Restaurant_Opinions> getaL_Opi() {
        return aL_Opi;
    }

}