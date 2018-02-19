<%@ page import="com.iesemilidarder.restaurants.web.DB_read" %>
<%@ page import="com.iesemilidarder.restaurants.web.Restaurant" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@include file="header.jsp"%>
<%--<%@include file="footer.jsp"%>--%>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="jumbotron">
        <div class="container">
            <h1 class="display-2 text-center">Restaurantes</h1>
            <p class="display-4 text-center "> Buscador de Restaurantes </p>
            <p><a class="btn btn-primary btn-lg" href="test" role="button">Saber mas &raquo;</a></p>
        </div>
    </div>


    <div class="container">
        <!-- bucles de informacion restaurantes -->
        <%
            DB_read readRestaurant = new DB_read();
            ArrayList arrayRestaurants = readRestaurant.readDB(request.getParameter("consulta"));
            Iterator itr = arrayRestaurants.iterator();

            while (itr.hasNext()) {
                Restaurant rst = (Restaurant) itr.next();
                out.println(
                        "<div class=\"row\">" + "<div class=\"col-md-4\">" +
                                "<img class=\"img-fluid\" src=\"" + rst.getRestaurant_imatge() + "\">" + "</div>" + "<div class=\"col-md-8\">" +
                                "<h3>" + rst.getRestaurant_name() + "</h3>" +
                                "<p>" + rst.getRestaurant_adreca() + "</p>" +
                                "<p>" + rst.getRestaurant_telefon() + "</p>" +
                                "<p>" + rst.getRestaurant_descripcio() + "</p>" +
                                "<p>" + "Puntuación: " + rst.getRestaurant_mitjana() + " ★" + "</p>" +
                                "<a target=\"_blank\" class=\"btn btn-primary btn-lg\" href=\"" + rst.getRestaurant_web() +
                                "\" role=\"button\">Pagina web</a> " + " <a target=\"_blank\" class=\"btn btn-primary btn-lg\" href=\"/showRestaurant?idRest=" + rst.getRestaurant_codi() +
                                "\" role=\"button\">Información</a>" + "</div></div>");
            }
        %>
        <hr>

    </div>  <!-- /container -->

</main>

<%--<%@include file="header.jsp"%>--%>
<%@include file="footer.jsp"%>