<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>PetShop</title>
  </head>
  <body>
  <h3>Welcome to the pet shop network</h3>
  <br/>
  <a href="<c:url value="/pets"/>">Pets list</a>
  <br/>
  <a href="<c:url value="/species"/>">Species list</a>
  </body>
</html>
