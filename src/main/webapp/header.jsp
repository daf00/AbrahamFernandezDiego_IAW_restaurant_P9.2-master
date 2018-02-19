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
                <a class="nav-link" href="http://localhost:8080/index.jsp">Inicio<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="test">Enlace 1</a>
            </li>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="test">Enlace 2</a>--%>
            <%--</li>--%>


            <%
                Users user = (Users) session.getAttribute("loginUsr");
                if (user != null) {
                    out.println("<li class=\"nav-item\"><a class=\"nav-link\">Usuario: " +  user.getUSU_NOM("userNom") + "</a></li>");
                    out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=/logout>Logout</a></li>");
                }
            %>
            <%--loginForm.jsp?logOut=out--%>
        </ul>
        <p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p>
        <p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p><p>&nbsp&nbsp</p>
        <form class="form-inline my-2 my-lg-0" method="get" action="index.jsp">
            <input class="form-control mr-sm-2" name="consulta" type="text" placeholder="Buscar" aria-label="Buscar">
            <button type="submit">Buscar</button>               <!-- class="btn btn-outline-success my-2 my-sm-0"  -->
        </form>
    </div>
</nav>