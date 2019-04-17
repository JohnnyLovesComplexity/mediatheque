<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<html>

<body>
<%@include file="navigation.jsp" %>
<form method="post" action="updateOeuvrePret.htm?id=${oeuvrepret.idOeuvrepret}">
    <div class="col-md-12 well well-md formulaire">
        <h1>Modifier Oeuvre en prêt</h1>
        <div class="form-horizontal">
            <div class="form-group">
                <label class="col-md-3 control-label">Titre de l'oeuvre : </label>
                <div class="col-md-3">
                    <INPUT type="text" name="txttitre" value="${oeuvrepret.titreOeuvrepret}" id="titre"
                           class="form-control" min="0">
                </div>
            </div>

            <%--<div class="form-group">--%>
            <%--<label class="col-md-3 control-label">Etat de l'oeuvre : </label>--%>
            <%--<div class="col-md-3">--%>
            <%--<input type="radio" name="etatoeuvre" value="R" checked="${oeuvrevente.etatoeuvreventre} == 'R'"> Réservé <br>--%>
            <%--<input type="radio" name="etatoeuvre" value="L" checked="${oeuvrevente.etatoeuvreventre} == 'R'"> Libre--%>
            <%--<br>--%>
            <%--</div>--%>

            <%--</div>--%>
            <%--<div class="row">--%>
            <%--<div class="col-md-12" style="border:none; background-color:transparent; height :20px;">--%>
            <%--</div>--%>
            <%--</div>--%>
            <div class="form-group">
                <label class="col-md-3 control-label">Propriétaire </label>
                <div class="col-md-3">
                    <select name="idProprietaire" size="1">
                        <c:forEach items="${proprietaires}" var="propr">
                            <%--TODO set default selected value--%>
                            <option value="${propr.idProprietaire}"
                                    selected="${oeuvrepret.idProprietaire == propr.idProprietaire}">${propr.nomProprietaire}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
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