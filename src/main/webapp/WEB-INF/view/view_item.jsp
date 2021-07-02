<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="fr.almamy.util.Mappings" %>
<html>
<head>
    <title>View Task# </title>
</head>
<body>
    <div align="center">
        <table  border="1" cellpadding="5">
            <tr>
                <td> Title </td>
                <td>${todoItem.title}</td>
            </tr>
            <tr>
                <td> Deadline </td>
                <td>${todoItem.deadline}</td>
            </tr>
            <tr>
                <td> Details </td>
                <td><c:out value="${todoItem.details}"/> </td>
            </tr>
        </table>

        <c:url var="tableUrl" value="${Mappings.ITEMS}" />
        <a href="${tableUrl}"> Show Table </a>

    </div>
</body>
</html>
