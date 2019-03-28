<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<html>
<head>
    <title>Modification oeuvre</title>
</head>
<body>
<%@include file="navigation.jsp" %>
<form method="post" action="updateOeuvreVente.htm?id=${oeuvrevente.idOeuvrevente}">
    <div class="col-md-12 well well-md">
        <h1>Modifier Oeuvre en vente</h1>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Titre de l'oeuvre : </label>
            <div class="col-md-3">
                <INPUT type="text" name="txttitre" value="${oeuvrevente.titreOeuvrevente}" id="titre"
                       class="form-control" min="0">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Prix de l'oeuvre : </label>
            <div class="col-md-3">
                <INPUT type="text" name="numberprix" value="${oeuvrevente.prixOeuvrevente}" id="prix"
                       class="form-control" min="0">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Etat de l'oeuvre : </label>
            <div class="col-md-3">
                <%--TODO set default checked value--%>
                <input type="radio" name="etatoeuvre" value="R" checked="${oeuvrevente.etatOeuvrevente == 'R'}"> Réservé
                <br>
                <input type="radio" name="etatoeuvre" value="L" checked="${oeuvrevente.etatOeuvrevente == 'L'}"> Libre
                <br>
            </div>

        </div>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Propriétaire </label>
            <div class="col-md-3">
                <select name="idProprietaire" size="1">
                    <c:forEach items="${proprietaires}" var="propr">
                        <%--TODO set default selected value--%>
                        <option value="${propr.idProprietaire}"
                                selected="${oeuvrevente.idProprietaire == propr.idProprietaire}">${propr.nomProprietaire}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
                Valider les modifications
            </button>

            <button type="button" class="btn btn-default btn-primary"
                    onclick="{
                            window.location = '../index.jsp';
                        }">
                <span class="glyphicon glyphicon-remove"></span> Annuler

            </button>
        </div>
    </div>
</form>
</body>
<%@include file="footer.jsp" %>
</html>
