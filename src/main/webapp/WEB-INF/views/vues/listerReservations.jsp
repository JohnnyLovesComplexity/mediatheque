<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body class="liste">
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
    <h1>Liste des réservations</h1>
</div>

<div class="container">
    <div class="container">
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Oeuvre</th>
                <th class="col-md-2">Adhérent</th>
                <th class="col-md-2">Date</th>
                <th class="col-md-2">Statut</th>
                <th class="col-md-2">Confirmer</th>
                <th class="col-md-2">Annuler</th>
            </tr>

            <c:forEach items="${reservations}" var="item">
                <tr>
                    <td>${item.oeuvreventeByIdOeuvrevente.titreOeuvrevente}</td>
                    <td>${item.adherentByIdAdherent.nomAdherent}</td>
                    <td>${item.dateReservation}</td>
                    <td>${item.statut}</td>
                    <td>
                        <c:if test="${item.statut == 'En attente'}">
                            <a class="btn btn-info" href="validerReservation.htm?id=${item.oeuvreventeByIdOeuvrevente.idOeuvrevente}&adh=${item.adherentByIdAdherent.idAdherent}&date=${item.dateReservation}"
                               role="button"><span class="glyphicon glyphicon-ok"></span></a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${item.statut != 'Annulee'}">
                            <a class="btn btn-danger" href="annulerReservation.htm?id=${item.oeuvreventeByIdOeuvrevente.idOeuvrevente}&adh=${item.adherentByIdAdherent.idAdherent}&date=${item.dateReservation}"
                               role="button"><span class="glyphicon glyphicon-remove"></span></a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>