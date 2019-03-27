<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Listing des Oeuvres</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="index.htm" role="button"><span class="glyphicon glyphicon-menu-left"></span>
        Retour accueil</a>
    <h2>Tableau des Oeuvres</h2>
    <div class="container">
        <h3>Liste des Oeuvres disponibles à la vente</h3>
        <a href="ajouterOeuvreVente.htm">
            <span class="glyphicon glyphicon-plus"></span>
            Ajout Oeuvre en vente
        </a>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Titre</th>
                <th class="col-md-2">Etat</th>
                <th class="col-md-2">Prix</th>
                <th class="col-md-4">Prénom propriétaire</th>
                <th class="col-md-4">Nom propriétaire</th>
            </tr>

            <c:forEach items="${oeuvres}" var="item">
                <tr>
                    <td>${item.titreOeuvrevente}</td>
                    <td>${item.etatOeuvrevente}</td>
                    <td>${item.prixOeuvrevente}</td>
                    <td>${item.proprietaire.prenomProprietaire}</td>
                    <td>${item.proprietaire.nomProprietaire}</td>
                    <td>
                        <c:if test="${item.etatOeuvrevente == 'R'}">
                        <a disabled class="btn btn-info"
                           role="button"><span class="glyphicon glyphicon-pencil"></span> Réserver</a>
                        </c:if>
                        <c:if test="${item.etatOeuvrevente != 'R'}">
                        <a class="btn btn-info" href="reserverOeuvre.htm?id=${item.idOeuvrevente}"
                           role="button"><span class="glyphicon glyphicon-pencil"></span> Réserver</a>
                        </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="container">
        <h3>Liste des Oeuvres disponibles au prêt</h3>
        <a href="ajouterOeuvrePret.htm">
            <span class="glyphicon glyphicon-plus"></span>
            Ajout Oeuvre en prêt
        </a>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Titre</th>
                <th class="col-md-4">Prénom propriétaire</th>
                <th class="col-md-4">Nom propriétaire</th>

            </tr>

            <c:forEach items="${oeuvrespret}" var="item">
                <tr>
                    <td>${item.titreOeuvrepret}</td>
                    <td>{item.proprietaire.prenomProprietaire}</td><!-- TODO: Put back '$' -->
                    <td>{item.proprietaire.nomProprietaire}</td><!-- TODO: Put back '$' -->
                    <!--
                    <td>
                        <c:if test="{item.etatOeuvrevente == 'R'}">TODO: Put back '$'
                        <a disabled class="btn btn-info"
                           role="button"><span class="glyphicon glyphicon-pencil"></span> Réserver</a>
                        </c:if>
                        <c:if test="{item.etatOeuvrevente != 'R'}">TODO: Put back '$'
                        <a class="btn btn-info" href="reserverOeuvre.htm?id={item.idOeuvrepret}"TODO: Put back '$'
                           role="button"><span class="glyphicon glyphicon-pencil"></span> Réserver</a>
                        </c:if>
                    </td>
                    -->
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
<%@include file="footer.jsp" %>
</body>

</html>