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

            <c:forEach items="${oeuvresvente}" var="vente">
                <tr>
                    <td>${vente.titreOeuvrevente}</td>
                    <td>${vente.etatOeuvrevente}</td>
                    <td>${vente.prixOeuvrevente}</td>
                    <td>${vente.proprietaireByIdProprietaire.prenomProprietaire}</td>
                    <td>${vente.proprietaireByIdProprietaire.nomProprietaire}</td>
                    <td>
                        <c:if test="${vente.etatOeuvrevente == 'R'}">
                            <a disabled class="btn btn-info"
                               role="button"><span class="glyphicon glyphicon-pencil"></span> Réserver</a>
                        </c:if>
                        <c:if test="${vente.etatOeuvrevente != 'R'}">
                            <a class="btn btn-info" href="reserverOeuvreVente.htm?id=${vente.idOeuvrevente}"
                               role="button"><span class="glyphicon glyphicon-pencil"></span> Réserver</a>
                        </c:if></td>
                    <td>
                        <a class="btn btn-info" href="modifierOeuvreVente.htm?id=${vente.idOeuvrevente}"
                           role="button"><span class="glyphicon glyphicon-pencil"></span> Modifier</a>
                    </td>
                    <td>
                        <a onclick="window.confirm('La suppression d\'une oeuvre est definitive')"
                           class="btn btn-danger" href="supprimerOeuvreVente.htm?id=${vente.idOeuvrevente}"
                           role="button"><span class="glyphicon glyphicon-remove-circle"></span> Supprimer</a>
                    </td>
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
                <th class="col-md-4">Etat</th>

            </tr>

            <c:forEach items="${oeuvrespret}" var="pret">
                <tr>
                    <td>${pret.titreOeuvrepret}</td>
                    <td>${pret.proprietaireByIdProprietaire.prenomProprietaire}</td>
                    <td>${pret.proprietaireByIdProprietaire.nomProprietaire}</td>
                    <td>${pret.etatOeuvrepret}</td>
                    <td>
                        <c:if test="${pret.etatOeuvrepret == 'R'}">
                            <a disabled class="btn btn-info"
                               role="button"><span class="glyphicon glyphicon-pencil"></span> Réserver</a>
                        </c:if>
                        <c:if test="${pret.etatOeuvrepret != 'R'}">
                            <a class="btn btn-info" href="emprunterOeuvrePret.htm?id=${pret.idOeuvrepret}"
                               role="button"><span class="glyphicon glyphicon-pencil"></span> Emprunter</a>
                        </c:if></td>
                    <td><a class="btn btn-info" href="modifierOeuvrePret.htm?id=${pret.idOeuvrepret}"
                           role="button"><span class="glyphicon glyphicon-pencil"></span> Modifier</a></td>
                    <td><a onclick="window.confirm('La suppression d\'une oeuvre est definitive')"
                           class="btn btn-danger" href="supprimerOeuvrePret.htm?id=${pret.idOeuvrepret}"
                           role="button"><span class="glyphicon glyphicon-remove-circle"></span> Supprimer</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
<%@include file="footer.jsp" %>
</body>

</html>