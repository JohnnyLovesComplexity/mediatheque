<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<html>
<head>
    <title>Modification adhérent</title>
</head>
<body>
<%@include file="navigation.jsp"%>
<form method="post" action="enregistrerReservation.htm?id=${oeuvreVente.idOeuvrevente}">
    <div class="col-md-12 well well-md">
        <h1>Réserver Oeuvre ${oeuvreVente.titreOeuvrevente}</h1>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Nom de l'adherent : </label>
            <div class="col-md-3">
                <select name="adherentId" size="1">
                    <c:forEach items="${mesAdherents}" var="item">
                        <option value="${item.idAdherent}">${item.nomAdherent}</option>
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