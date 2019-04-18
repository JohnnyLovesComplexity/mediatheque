<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body class="liste">
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Liste des oeuvres à la vente</h1>
</div>

<div class="container">
    <div class="container">
        <a href="ajouterOeuvreVente.htm">
            <span class="glyphicon glyphicon-plus"></span>
            Ajout d'une oeuvre en vente
        </a>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Titre</th>
                <th class="col-md-2">Prix</th>
                <th class="col-md-4">Prénom propriétaire</th>
                <th class="col-md-4">Nom propriétaire</th>
                <th class="col-md-2">Etat</th>
                <th class="col-md-4">Edition</th>
                <th class="col-md-4">Réservation</th>
                <th class="col-md-4">Suppression</th>
            </tr>

            <c:forEach items="${oeuvresvente}" var="vente">
                <tr>
                    <td>${vente.titreOeuvrevente}</td>
                    <td>${vente.prixOeuvrevente}</td>
                    <td>${vente.proprietaireByIdProprietaire.prenomProprietaire}</td>
                    <td>${vente.proprietaireByIdProprietaire.nomProprietaire}</td>
                    <td>
                        <c:if test="${vente.etatOeuvrevente == 'R'}">
                            Réservée
                        </c:if>
                        <c:if test="${vente.etatOeuvrevente == 'L'}">
                            Libre
                        </c:if>
                    </td>
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

    <div class="jumbotron text-center">
        <h1>Liste des oeuvres en prêt</h1>
    </div>

    <div class="container">
*        <a href="ajouterOeuvrePret.htm">
            <span class="glyphicon glyphicon-plus"></span>
            Ajout Oeuvre en prêt
        </a>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Titre</th>
                <th class="col-md-4">Prénom propriétaire</th>
                <th class="col-md-4">Nom propriétaire</th>
                <th class="col-md-4">Etat</th>
                <th class="col-md-4">Edition</th>
                <th class="col-md-4">Réservation</th>
                <th class="col-md-4">Suppression</th>
            </tr>

            <c:forEach items="${oeuvrespret}" var="pret">
                <tr>
                    <td>${pret.titreOeuvrepret}</td>
                    <td>${pret.proprietaireByIdProprietaire.prenomProprietaire}</td>
                    <td>${pret.proprietaireByIdProprietaire.nomProprietaire}</td>
                    <td>
                        <c:if test="${pret.etatOeuvrepret == 'R'}">
                            Réservée
                        </c:if>
                        <c:if test="${pret.etatOeuvrepret == 'L'}">
                            Libre
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${pret.etatOeuvrepret == 'R'}">
                            <a disabled class="btn btn-info"
                               role="button"><span class="glyphicon glyphicon-pencil"></span> Emprunter</a>
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
</body>

</html>