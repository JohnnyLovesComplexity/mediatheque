<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<html>
<head>
    <title>Réservation oeuvre</title>
</head>
<body>
<%@include file="navigation.jsp"%>
<form method="post" action="enregistrerReservation.htm?id=${oeuvre.idOeuvrevente}">
    <div class="col-md-12 well well-md">
        <h1>Réserver Oeuvre ${oeuvre.titreOeuvrevente}</h1>
        <div class="form-group">
            <label class="col-md-3 control-label">Titre de l'oeuvre : </label>
            <div class="col-md-3">
                <input disabled type="text" name="txttitre" value="${oeuvre.titreOeuvrevente}" id="titre" class="form-control">
            </div>

        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Prix de l'oeuvre : </label>
            <div class="col-md-3">
                <input disabled type="text" name="txtprix" value="${oeuvre.prixOeuvrevente}" id="prix" class="form-control">
            </div>

        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Nom de l'adherent : </label>
            <div class="col-md-3">
                <select name="adherentId" size="1">
                    <c:forEach items="${adherents}" var="adh">
                        <option value="${adh.idAdherent}">${adh.nomAdherent}</option>
                    </c:forEach>
                </select>
            </div>

        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
                Réserver
            </button>

            <button type="button" class="btn btn-default btn-primary"
                    onclick="{
                            window.location = './';
                        }">
                <span class="glyphicon glyphicon-remove"></span> Annuler

            </button>
        </div>
    </div>
</form>
</body>
<%@include file="footer.jsp"%>
</html>