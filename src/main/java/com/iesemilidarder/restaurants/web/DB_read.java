package com.iesemilidarder.restaurants.web;

import java.sql.*;
import java.util.ArrayList;

public class DB_read {
// LEE LA DB y busca los restaurantes
    public ArrayList readDB(String consulta) {          // boton de busqueda
        ArrayList al = new ArrayList();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");
            Statement stmt = con.createStatement();

            ResultSet rs;
//solo la busqueda
//            stmt.executeQuery("SELECT R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM " +
//              "RESTAURANTS R,TRESTAURANTS TR WHERE ROWNUM <= 5 AND R.RES_TRS_CODI = TR.TRS_CODI ORDER BY RES_MITJANA DESC");
//if del boton de busqueda
            if (consulta == null) {
                rs = stmt.executeQuery
                        ("SELECT R.RES_CODI, R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM " +
                                "RESTAURANTS R,TRESTAURANTS TR WHERE ROWNUM <= 5 AND R.RES_TRS_CODI = TR.TRS_CODI ORDER BY RES_MITJANA DESC");
            } else {
                rs = stmt.executeQuery
                        ("SELECT R.RES_CODI, R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO " +
                                "FROM RESTAURANTS R,TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI" +
                                " AND LOWER (RES_NOM) LIKE '%" + consulta.toLowerCase() + "%' ORDER BY RES_MITJANA DESC");
            }

            while (rs.next()) {
                String restNombre = rs.getString("RES_NOM");
                String restWeb = rs.getString("RES_WEB");
                String restDireccion = rs.getString("RES_ADRECA");
                String restTelefono = rs.getString("RES_TELEFON");
                String tresDescripcion = rs.getString("TRS_DESCRIPCIO");
                String restUrlImagen = rs.getString("RES_URL_IMG");
                String restMitjana = rs.getString("RES_MITJANA");
                String restCodi = rs.getString("RES_CODI");

                Restaurant rst = new Restaurant();
                rst.setRestaurant_name(restNombre);
                rst.setRestaurant_web(restWeb);
                rst.setRestaurant_adreca(restDireccion);
                rst.setRestaurant_telefon(restTelefono);
                rst.setRestaurant_descripcio(tresDescripcion);
                rst.setRestaurant_imatge(restUrlImagen);
                rst.setRestaurant_mitjana(restMitjana);
                rst.setRestaurant_codi(restCodi);

                al.add(rst);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return al;
    }


// LEE LA DB y busca las OPINIONES del restaurante BUSCADO

    public Restaurant readInfo(String idRest) {
       Restaurant rest = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");
            Statement stmt = con.createStatement();

            ResultSet rs;
//  OPI_CODI, OPI_OBSERVACIO, OPI_PUNTUACIO, OPI_OPINIO_REVISADA, OPI_RES_CODI, OPI_USU_CODI,

            rs = stmt.executeQuery
                    ("SELECT R.RES_CODI, R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM " +
                            "RESTAURANTS R,TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI AND R.RES_CODI="+idRest);

            if (rs.next()) {
                String restNombre = rs.getString("RES_NOM");
                String restWeb = rs.getString("RES_WEB");
                String restDireccion = rs.getString("RES_ADRECA");
                String restTelefono = rs.getString("RES_TELEFON");
                String tresDescripcion = rs.getString("TRS_DESCRIPCIO");
                String restUrlImagen = rs.getString("RES_URL_IMG");
                String restMitjana = rs.getString("RES_MITJANA");
                String restCodi = rs.getString("RES_CODI");

                rest = new Restaurant();
                rest.setRestaurant_name(restNombre);
                rest.setRestaurant_web(restWeb);
                rest.setRestaurant_adreca(restDireccion);
                rest.setRestaurant_telefon(restTelefono);
                rest.setRestaurant_descripcio(tresDescripcion);
                rest.setRestaurant_imatge(restUrlImagen);
                rest.setRestaurant_mitjana(restMitjana);
                rest.setRestaurant_codi(restCodi);
            }

            rs = stmt.executeQuery("SELECT O.OPI_CODI, O.OPI_OBSERVACIO, O.OPI_PUNTUACIO, O.OPI_OPINIO_REVISADA, O.OPI_RES_CODI, O.OPI_USU_CODI " +
                    "FROM OPINIONS O WHERE O.OPI_RES_CODI = " + idRest);

            while (rs.next()) {
                String opinionCodi = rs.getString("OPI_CODI");
                String opinionObservacio = rs.getString("OPI_OBSERVACIO");
                String opinionpuntuacio = rs.getString("OPI_PUNTUACIO");
                String opinionRevisada = rs.getString("OPI_OPINIO_REVISADA");
                String opinionResCodi = rs.getString("OPI_RES_CODI");
                String opinionUsuCodi = rs.getString("OPI_USU_CODI");

                Restaurant_Opinions opi = new Restaurant_Opinions();
                opi.setOPI_CODI(opinionCodi);
                opi.setOPI_OBSERVACIO(opinionObservacio);
                opi.setOPI_PUNTUACIO(opinionpuntuacio);
                opi.setOPI_OPINIO_REVISADA(opinionRevisada);
                opi.setOPI_RES_CODI(opinionResCodi);
                opi.setOPI_USU_CODI(opinionUsuCodi);

                rest.getaL_Opi().add(opi);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rest;

    }


// LEE LA DB y comprueba si existe el Usuario (userLogin)

//    public ArrayList readUser(String usuLogin) {          // boton de loggin
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");
//
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery
//                        ("SELECT USU_CODI,USU_PASSWORD, USU_NOM, USU_ADRECA_ELECTRONICA " +
//                                " FROM USUARIS"+
//                                " WHERE USU_CODI = " + usuLogin +
//                                " OR USU_ADRECA_ELECTRONICA = " + usuLogin
//                        );
//
//
//
//            while (rs.next()) {
//                String usuCodi = rs.getString("USU_CODI");
//                String usuPsw = rs.getString("USU_PASSWORD");
//                String usuNom = rs.getString("USU_NOM");
//                String usuMail = rs.getString("USU_ADRECA_ELECTRONICA");
//
//                Users usr  = new Users();
//                usr.setUSU_CODI(usuCodi);
//                usr.setUSU_PASSWORD(usuPsw);
//                usr.setUSU_NOM(usuNom);
//                usr.setUSU_ADRECA_ELECTRONICA(usuMail);
//
//            }
//            stmt.close();
//            con.close();
//
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        return XXXX;
//    }

}

