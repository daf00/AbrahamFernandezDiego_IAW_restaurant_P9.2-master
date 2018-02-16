<%@ page import="com.iesemilidarder.restaurants.web.Restaurant" %>
<%@ page import="com.iesemilidarder.restaurants.web.Restaurant_Opinions" %>
<%--
  Created by IntelliJ IDEA.
  User: cicles
  Date: 22/1/2018
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<main role="main">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="container">
        <!-- bucles de informacion restaurantes -->
        <%
            Restaurant rst = (Restaurant) request.getAttribute("rest");
            if (rst != null) {
                out.println("<p>.</p>");
                out.println("<p>.</p>");
                out.println("<p><h1>Opinions del restaurant:</h1></p>");
                out.println("<p><h3>" + rst.getRestaurant_name() + "</h3></p>");

                for (Restaurant_Opinions opini : rst.getaL_Opi()) {
                    out.println("<div class=\"col-md-1\"></div><div class=\"col-md-10\"> " +
                            "<div>Usuari: " + opini.getOPI_USU_CODI().toUpperCase() +"</div> <div>Puntuacion: "+ opini.getOPI_PUNTUACIO() +
                            "★</div> <div>Opinion revisada: " + opini.getOPI_OPINIO_REVISADA() +
                            "</div> <div><p>" + opini.getOPI_OBSERVACIO() + "</div></p>" +
                            "</div>" + "<div class=\"col-md-1\"></div><p></p>");
                };
            } else {
                out.println("<p>NO SELECCIONA EL RESTAURANTE </p><p> </p>");
                out.println("<p>NO SELECCIONA EL RESTAURANTE </p><p> </p>");
                out.println("<p>NINGUN RESTAURANTE SELECCIONADO </p> <p></p>");
            }
        %>
        <hr>

    </div>  <!-- /container -->

</main>

<%@include file="footer.jsp"%>


