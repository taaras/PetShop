<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet data</title>

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
<table class="tg">
    <tr>
        <th width="45">ID</th>
        <th width="150">Species</th>
        <th width="75">Age (months)</th>
        <th width="75">Gender</th>
        <th width="75">Price</th>
        <th width="180">Additional</th>
    </tr>
    <tr>
        <td>${pet.id}</td>
        <td><a href="/speciesdata/${pet.species.id}" target="_blank">${pet.species.latinTitle}</a></td>
        <td>${pet.ageInMonth}</td>
        <td>${pet.gender}</td>
        <td>${pet.price/100}${pet.price%100}</td>
        <td><p>${pet.additional}</p></td>
    </tr>
</table>
</body>
</html>
