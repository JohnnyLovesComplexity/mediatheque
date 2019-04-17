<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<form method="post" action="insererAdherent.htm" onsubmit="return teste()">
    <div class="col-md-12 well well-md formulaire">
        <h1>Ajouter adhérent</h1>
        <div class="form-horizontal">
            <div class="form-group">
                <label class="col-md-3 control-label">Nom de l'adherent : </label>
                <div class="col-md-3">
                    <INPUT type="text" name="txtnom" value="" id="nom" class="form-control" min="0">
                </div>

            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">Prénom de l'adherent : </label>
                <div class="col-md-3">
                    <INPUT type="text" name="txtprenom" value="" id="prenom" class="form-control" min="0">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">Ville de l'adherent : </label>
                <div class="col-md-3">
                    <INPUT type="text" name="txtville" value="" id="ville" class="form-control" min="0">
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