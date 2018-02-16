package com.iesemilidarder.restaurants.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//  http://localhost:8080/showRestaurant
@WebServlet(name = "showRestaurantServlet")
public class showRestaurantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB_read readOpi = new DB_read();

        String idRest = request.getParameter("idRest");
        Restaurant rest = readOpi.readInfo(idRest);
        request.setAttribute("rest", rest);
        request.getRequestDispatcher("showRestaurant.jsp").forward(request, response);
    }
}
