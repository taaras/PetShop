<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Species data</title>

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
        <th width="150">Latin title</th>
        <th width="75">Male average age</th>
        <th width="75">Female average age</th>
        <th width="75">Nutrition</th>
    </tr>
    <tr>
        <td>${species.id}</td>
        <td>${species.latinTitle}</td>
        <td>${species.maleAverageAge}</td>
        <td>${species.femaleAverageAge}</td>
        <td>${species.nutrition}</td>
    </tr>
</table>
</body>
</html>
