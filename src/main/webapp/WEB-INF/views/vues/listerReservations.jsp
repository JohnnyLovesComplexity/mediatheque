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

            </tr>

            <c:forEach items="${mesReservations}" var="vente">
                <tr>
                    <td>${vente.oeuvrevente.titreOeuvrevente}</td>
                    <td>${vente.adherent.nomAdherent}</td>
                    <td>${vente.date}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>

</html>