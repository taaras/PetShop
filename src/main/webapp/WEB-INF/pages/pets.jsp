<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pets page</title>

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

    <h1>Pet list</h1>

    <c:if test="${!empty listPets}">
        <table class="tg">
            <tr>
                <th width="45">ID</th>
                <th width="150">Species</th>
                <th width="75">Age (months)</th>
                <th width="75">Gender</th>
                <th width="75">Price</th>
                <th width="50">Edit</th>
                <th width="50">Delete</th>
            </tr>
            <c:forEach items="${listPets}" var="pet">
                <tr>
                    <td>${pet.id}</td>
                    <td><a href="/speciesdata/${pet.species.id}" target="_blank">${pet.species.latinTitle}</a></td>
                    <td>${pet.ageInMonth}</td>
                    <td>${pet.gender}</td>
                    <td>${pet.price/100}${pet.price%100}</td>
                    <td><a href="<c:url value='pets/edit/${pet.id}'/>">Edit</a></td>
                    <td><a href="<c:url value='pets/remove/${pet.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <h1>Add a pet</h1>

    <c:url var="addAction" value="/pets/add"/>

<form:form action="${addAction}" commandName="pet">
    <table>
        <c:if test="${!empty pet.species}">
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
                <form:label path="species">
                    <spring:message text="Species"/>
                </form:label>
            </td>
            <td>
                <form:select path="species.id" items="${speciesMap}" itemValue="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="ageInMonth">
                    <spring:message text="Age(months)"/>
                </form:label>
            </td>
            <td>
                <form:input path="ageInMonth"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="gender">
                    <spring:message text="Gender"/>
                </form:label>
            </td>
            <td>
                <form:select path="gender" items="${genderMap}"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="additional">
                    <spring:message text="Additional"/>
                </form:label>
            </td>
            <td>
                <form:textarea path="additional" cols="45" rows="5" maxlength="500"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty pet.species}">
                    <input type="submit"
                           value="<spring:message text="Edit pet"/>"/>
                </c:if>
                <c:if test="${empty pet.species}">
                    <input type="submit"
                           value="<spring:message text="Add pet"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
