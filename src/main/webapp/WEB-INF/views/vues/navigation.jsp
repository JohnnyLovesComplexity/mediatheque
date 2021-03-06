<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<c:if test="${sessionScope.id > 0  }">
    <div class="container">
    <nav class="navbar navbar-inverse">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="index.htm">Médiathèque de POLYTECH</a>
    </div>
    <a href="index.htm"><p class="navbar-text">Gestion de l'exposition 2019</p></a>
    <ul class="nav navbar-nav">
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <span class="glyphicon glyphicon-user"></span>
            Adhérents
            <span class="caret"></span>
        </a>

        <ul class="dropdown-menu">
            <li><a href="ajouterAdherent.htm"> <span class="glyphicon glyphicon-plus"></span> Ajout Adhérent</a>
            </li>
            <li><a href="listerAdherent.htm"><span class="glyphicon glyphicon-th-list"></span> Lister les
                adhérents</a></li>
        </ul>
    </li>

    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <span class="glyphicon glyphicon-credit-card"></span>
            Gestion
            <span class="caret"></span>
        </a>

        <ul class="dropdown-menu">
            <li><a href="listerEmprunts.htm"> <span class="glyphicon glyphicon-th-list"></span> Emprunts
            </a></li>
            <li><a href="listerReservations.htm"><span class="glyphicon glyphicon-th-list"></span>
                Réservations</a></li>
        </ul>
    </li>

    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <span class="glyphicon glyphicon-book"></span>
            Oeuvres
            <span class="caret"></span>
        </a>

        <ul class="dropdown-menu">
            <li>
                <a href="ajouterOeuvreVente.htm">
                    <span class="glyphicon glyphicon-plus"></span>
                    Ajout Oeuvre en vente
                </a><a href="ajouterOeuvrePret.htm">
                <span class="glyphicon glyphicon-plus"></span>
                Ajout Oeuvre en prêt
            </a>
            </li>
            <li>
                <a href="listerOeuvre.htm">
                    <span class="glyphicon glyphicon-th-list"></span>
                    Lister Oeuvre
                </a>
            </li>
        </ul>
    </li>

    <li><a href="logout.htm"><span class="glyphicon glyphicon-log-out"></span> Quitter</a></li>
</c:if>

</ul>
</div>
</nav>
</div>