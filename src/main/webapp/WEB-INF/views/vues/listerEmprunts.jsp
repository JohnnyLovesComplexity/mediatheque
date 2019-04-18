<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body class="liste">
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
  <h1>Liste des emprunts</h1>
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

            <c:forEach items="${emprunts}" var="item">
                <tr>
                    <td>${item.oeuvrepretByIdOeuvrepret.titreOeuvrepret}</td>
                    <td>${item.adherentByIdAdherent.nomAdherent}</td>
                    <td>${item.dateReservation}</td>
                    <td>${item.statusByIdStatut.name}</td>
                    <td>
                        <c:if test="${item.statusByIdStatut.name == 'En attente'}">
                            <a class="btn btn-info" href="validerEmprunt.htm?id=${item.oeuvrepretByIdOeuvrepret.idOeuvrepret}&adh=${item.adherentByIdAdherent.idAdherent}&date=${item.dateReservation}"
                               role="button"><span class="glyphicon glyphicon-ok"></span></a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${item.statusByIdStatut.name != 'Annule'}">
                            <a class="btn btn-danger" href="annulerEmprunt.htm?id=${item.oeuvrepretByIdOeuvrepret.idOeuvrepret}&adh=${item.adherentByIdAdherent.idAdherent}&date=${item.dateReservation}"
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