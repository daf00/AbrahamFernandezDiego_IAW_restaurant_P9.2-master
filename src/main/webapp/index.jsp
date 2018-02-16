<%@ page import="com.iesemilidarder.restaurants.web.DB_read" %>
<%@ page import="com.iesemilidarder.restaurants.web.Restaurant" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>





<%@ page import="com.iesemilidarder.restaurants.web.Users" %>
<!doctype html>
<html lang="ca">
<head>
    <title>Restaurants</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Satisfy|Bree+Serif|Candal|PT+Sans">
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<!-- Navigation bar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <%--<a class="navbar-brand" href="#">Restaurantes</a>--%>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">


        <a class="navbar-brand" href="#">Restaurantes</a>

        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="http://localhost:8080">Inicio<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="test">Enlace 1</a>
            </li>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="test">Enlace 2</a>--%>
            <%--</li>--%>
        </ul>

        <%
            Users user = (Users) session.getAttribute("loginUsr");
            if (user != null) {
                out.println("<li class=\"nav-item active\"><a> class=\"nav-item\">Usuario: " + user.getUSU_NOM("userNom")+"</a>");
                out.println("'<a href=loginForm.jsp>Logout</a></li>");
          }
        %>
               <%--loginForm.jsp?logOut=out--%>

        <p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p>
        <p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p>
        <form class="form-inline my-2 my-lg-0" method="get" action="index.jsp">
            <input class="form-control mr-sm-2" name="consulta" type="text" placeholder="Buscar" aria-label="Buscar">
            <button type="submit">Buscar</button>               <!-- class="btn btn-outline-success my-2 my-sm-0"  -->
        </form>
    </div>
</nav>

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
<%--<%@include file="footer.jsp"%>--%>


<footer class="container">
    <p>&copy; Diego Abraham Fernandez, 2018</p>
</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
</body>
</html>
