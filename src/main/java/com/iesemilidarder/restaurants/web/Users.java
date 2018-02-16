package com.iesemilidarder.restaurants.web;

public class Users {
    private String USU_CODI;
    private String USU_PASSWORD;
    private String USU_NOM;
    private String USU_ADRECA_ELECTRONICA;

    public Users() {
    }

    public String getUSU_CODI(String usuCodi) {
        return USU_CODI;
    }
    public void setUSU_CODI(String USU_CODI) {
        this.USU_CODI = USU_CODI;
    }

    public String getUSU_PASSWORD(String usuPassword) {
        return USU_PASSWORD;
    }
    public void setUSU_PASSWORD(String USU_PASSWORD) {
        this.USU_PASSWORD = USU_PASSWORD;
    }

    public String getUSU_NOM(String userNom) {
        return USU_NOM;
    }
    public void setUSU_NOM(String USU_NOM) {
        this.USU_NOM = USU_NOM;
    }

    public String getUSU_ADRECA_ELECTRONICA(String usuAdrecaElectronica) {
        return USU_ADRECA_ELECTRONICA;
    }
    public void setUSU_ADRECA_ELECTRONICA(String USU_ADRECA_ELECTRONICA) {
        this.USU_ADRECA_ELECTRONICA = USU_ADRECA_ELECTRONICA;
    }
}
