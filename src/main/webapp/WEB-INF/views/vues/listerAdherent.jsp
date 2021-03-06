<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body class="liste">
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Liste des adhérents</h1>
</div>

<div class="container">
    <div class="container">
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Numero</th>
                <th class="col-md-2">Nom</th>
                <th class="col-md-2">Prénom</th>
                <th class="col-md-4">Ville</th>
                <th class="col-md-4">Edition</th>

            </tr>

            <c:forEach items="${mesAdherents}" var="vente">
                <tr>
                    <td>${vente.idAdherent}</td>
                    <td>${vente.nomAdherent}</td>
                    <td>${vente.prenomAdherent}</td>
                    <td>${vente.villeAdherent}</td>
                    <td><a class="btn btn-info" href="afficherAdherent.htm?id=${vente.idAdherent}" role="button"><span
                            class="glyphicon glyphicon-pencil"></span></a>
                        <a onclick="window.confirm('La suppression d\'un adhérent est definitive')"
                           class="btn btn-danger" href="supprimerAdherent.htm?id=${vente.idAdherent}"
                           role="button"><span
                                class="glyphicon glyphicon-remove-circle"></span></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>