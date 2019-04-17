<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
    <h1>Listing des Réservations</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="index.htm" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Réservations</h2>
    <div class="container">
        <h3>Liste des Réservations</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Oeuvre</th>
                <th class="col-md-2">Adhérent</th>
                <th class="col-md-2">Date</th>
                <th class="col-md-2">Statut</th>
            </tr>

            <c:forEach items="${reservations}" var="item">
                <tr>
                    <td>${item.oeuvreventeByIdOeuvrevente.titreOeuvrevente}</td>
                    <td>${item.adherentByIdAdherent.nomAdherent}</td>
                    <td>${item.dateReservation}</td>
                    <td>${item.statut}</td>
                    <td>
                        <a class="btn btn-info" href="validerReservation.htm?id=${item.oeuvreventeByIdOeuvrevente.idOeuvrevente}"
                           role="button"><span class="glyphicon glyphicon-ok"></span></a>
                        <a class="btn btn-danger" href="annulerReservation.htm?id=${item.oeuvreventeByIdOeuvrevente.idOeuvrevente}"
                           role="button"><span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>

</html>