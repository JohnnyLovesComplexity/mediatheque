<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<html>

<body>
<%@include file="navigation.jsp" %>
<form method="post" action="updateAdherent.htm?id=${adherent.idAdherent}">
    <div class="col-md-12 well well-md formulaire">
        <h1>Modifier Adhérent</h1>
        <div class="form-horizontal">
            <div class="form-group">
                <label class="col-md-3 control-label">Nom de l'adherent : </label>
                <div class="col-md-3">
                    <INPUT type="text" name="txtnom" value="${adherent.nomAdherent}" id="nom" class="form-control"
                           min="0">
                </div>

            </div>

            <div class="form-group">
                <label class="col-md-3 control-label">Prénom de l'adherent : </label>
                <div class="col-md-3">
                    <INPUT type="text" name="txtprenom" value="${adherent.prenomAdherent}" id="prenom"
                           class="form-control" min="0">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-3 control-label">Ville de l'adherent : </label>
                <div class="col-md-3">
                    <INPUT type="text" name="txtville" value="${adherent.villeAdherent}" id="ville" class="form-control"
                           min="0">
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
