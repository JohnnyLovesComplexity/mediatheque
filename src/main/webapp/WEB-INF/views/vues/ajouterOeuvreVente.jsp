<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<form method="post" action="insererOeuvreVente.htm" onsubmit="return teste()">
    <div class="col-md-12 well well-md formulaire">
        <h1>Ajouter une oeuvre en vente</h1>
        <div class="form-horizontal">
            <div class="form-group">
                <label class="col-md-3 control-label">Titre de l'oeuvre </label>
                <div class="col-md-3">
                    <INPUT type="text" name="txttitre" value="" id="titre" class="form-control" min="0">
                </div>

            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">Prix </label>
                <div class="col-md-3">
                    <INPUT type="number" name="numberprix" value="" id="prix" class="form-control" min="0">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">Propriétaire </label>
                <div class="col-md-3">
                    <select name="idProprietaire" size="1">
                        <c:forEach items="${proprietaires}" var="propr">
                            <option value="${propr.idProprietaire}">${propr.nomProprietaire}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-6 col-md-offset-3">

                    <button type="submit" class="btn btn-default btn-primary"><span
                            class="glyphicon glyphicon-ok"></span>
                        Ajouter
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
<%@include file="footer.jsp" %>
</body>

</html>