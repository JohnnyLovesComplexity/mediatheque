<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<html>
<body>
<%@include file="navigation.jsp" %>
<form method="post" action="updateOeuvreVente.htm?id=${oeuvrevente.idOeuvrevente}">
    <div class="col-md-12 well well-md formulaire">
        <h1>Modifier Oeuvre en vente</h1>
        <div class="form-horizontal">
            <div class="form-group">
                <label class="col-md-3 control-label">Titre de l'oeuvre : </label>
                <div class="col-md-3">
                    <INPUT type="text" name="txttitre" value="${oeuvrevente.titreOeuvrevente}" id="titre"
                           class="form-control" min="0">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">Prix de l'oeuvre : </label>
                <div class="col-md-3">
                    <INPUT type="text" name="numberprix" value="${oeuvrevente.prixOeuvrevente}" id="prix"
                           class="form-control" min="0">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">Etat de l'oeuvre : </label>
                <div class="col-md-3">
                    <%--TODO set default checked value--%>
                    <input type="radio" name="etatoeuvre" value="R" checked="${oeuvrevente.etatOeuvrevente == 'R'}">
                    Réservé
                    <br>
                    <input type="radio" name="etatoeuvre" value="L" checked="${oeuvrevente.etatOeuvrevente == 'L'}">
                    Libre
                    <br>
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


            <div class="form-group">
                <div class="col-md-6 col-md-offset-3">

                    <button type="submit" class="btn btn-default btn-primary"><span
                            class="glyphicon glyphicon-ok"></span>
                        Valider les modifications
                    </button>

                    <button type="button" class="btn btn-default btn-primary"
                            onclick="{
                            window.location = './';
                        }">
                        <span class="glyphicon glyphicon-remove"></span> Annuler

                    </button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<%@include file="footer.jsp" %>
</html>
