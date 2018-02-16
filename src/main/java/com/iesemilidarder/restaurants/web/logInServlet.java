package com.iesemilidarder.restaurants.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//  http://localhost:8080/logIn
public class logInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // cojer los valores de userPwd y user userLogin
        String loginUsr = request.getParameter("userLogin");
        String loginPwd = request.getParameter("userPwd");
        String loginSHApwd = Sha256.hashSha256(loginPwd);

        PrintWriter out = response.getWriter();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            PreparedStatement stmt = con.prepareStatement(
                    "SELECT USU_CODI ,USU_PASSWORD, USU_NOM, USU_ADRECA_ELECTRONICA" +
                    " FROM USUARIS" +
                    " WHERE USU_CODI = '" + loginUsr +"'"+
                    " AND USU_PASSWORD = '" + loginSHApwd + "'");

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                Users usr = new Users();
                String userCodi = rs.getString("USU_CODI");
                String userNom = rs.getString("USU_NOM");
                String userAdrecaElectronica = rs.getString("USU_ADRECA_ELECTRONICA");

                usr.setUSU_CODI(userCodi);
                usr.setUSU_NOM(userNom);
                usr.setUSU_ADRECA_ELECTRONICA(userAdrecaElectronica);

                HttpSession ses = request.getSession(true);
                ses.setAttribute("loginUsr",usr);
                request.getRequestDispatcher("index.jsp").forward(request,response);
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            out.println(e.toString());
        }
    }
}
































//        Users logUsr = logging.readUser(loginUsr);
//        Users logPwd = logging.readPsw(loginPwd);
//
//        request.setAttribute("logUsr", logUsr);
//        request.setAttribute("logPwd", logPwd);


//        if validUsr == ok {
//            request.getRequestDispatcher("indexLoged.jsp").forward(request, response);
//        }else {
//            request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
//
//    }






