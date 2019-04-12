<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<html>
<head>
    <title>Emprunt oeuvre</title>
</head>
<body>
<%@include file="navigation.jsp"%>
<form method="post" action="enregistrerEmprunt.htm?id=${oeuvre.idOeuvrepret}">
    <div class="col-md-12 well well-md">
        <h1>Réserver Oeuvre ${oeuvre.titreOeuvrepret}</h1>
        <div class="form-group">
            <label class="col-md-3 control-label">Titre de l'oeuvre : </label>
            <div class="col-md-3">
                <input disabled type="text" name="txttitre" value="${oeuvre.titreOeuvrepret}" id="titre" class="form-control">
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
                Emprunter
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