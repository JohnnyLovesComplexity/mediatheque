<%--
  Created by IntelliJ IDEA.
  User: christian
  Date: 06/04/2018
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="vues/header.jsp" %>
<body>
<%@include file="vues/navigation.jsp" %>
<div class="jumbotron text-center home-page">

    <h1>Bienvenue sur Polydiathèque</h1>
    <h2>La meilleure médiathèque.</h2>
    <c:if test="${sessionScope.id == null  }">
        <div class="se-connecter"><a href="/login.htm">Se connecter</a></div>
    </c:if>
</div>
<%@include file="vues/footer.jsp" %>
</body>
</html>
