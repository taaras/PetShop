<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Species page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            text-align: center;
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>

<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Species list</h1>

<c:if test="${!empty listSpecies}">
    <table class="tg">
        <tr>
            <th width="45">ID</th>
            <th width="150">Latin title</th>
            <th width="75">Male average age</th>
            <th width="75">Female average age</th>
            <th width="75">Nutrition</th>
            <th width="50">Edit</th>
            <th width="50">Delete</th>
        </tr>
        <c:forEach items="${listSpecies}" var="species">
            <tr>
                <td>${species.id}</td>
                <td><a href="/speciesdata/${species.id}" target="_blank">${species.latinTitle}</a></td>
                <td>${species.maleAverageAge}</td>
                <td>${species.femaleAverageAge}</td>
                <td>${species.nutrition}</td>
                <td><a href="<c:url value='species/edit/${species.id}'/>">Edit</a></td>
                <td><a href="<c:url value='species/remove/${species.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a species</h1>

<c:url var="addAction" value="/species/add"/>

<form:form action="${addAction}" commandName="species">
    <table>
        <c:if test="${!empty species.latinTitle}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="latinTitle">
                    <spring:message text="Latin title"/>
                </form:label>
            </td>
            <td>
                <form:input path="latinTitle"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="maleAverageAge">
                    <spring:message text="Male average age"/>
                </form:label>
            </td>
            <td>
                <form:input path="maleAverageAge"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="femaleAverageAge">
                    <spring:message text="Female average age"/>
                </form:label>
            </td>
            <td>
                <form:input path="femaleAverageAge"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="nutrition">
                    <spring:message text="Nutrition"/>
                </form:label>
            </td>
            <td>
                <form:select path="nutrition" items="${nutritionMap}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty species.latinTitle}">
                    <input type="submit"
                           value="<spring:message text="Edit species"/>"/>
                </c:if>
                <c:if test="${empty species.latinTitle}">
                    <input type="submit"
                           value="<spring:message text="Add species"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
