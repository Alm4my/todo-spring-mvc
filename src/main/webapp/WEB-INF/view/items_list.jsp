<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.almamy.util.Mappings" %>

<html>
<head>
    <title>Todo Items</title>
</head>
<body>
    <div align="center">
        <c:url var="addURL" value="${Mappings.ADD_ITEM}" />
        <h2><a href="${addURL}">Add Task</a></h2>

        <table border="1" cellpadding="5">
            <caption><h2>Todo Items</h2></caption>
            <tr>
                <td> Title </td>
                <td> Deadline </td>
                <td> Delete </td>
            </tr>

            <jsp:useBean id="todoData" scope="request" type="fr.almamy.model.TodoData"/>
            <c:forEach var="item" items="${todoData.items}">
                <tr>
                    <td> <c:out value="${item.title}" /> </td>
                    <td> <c:out value="${item.deadline}" /> </td>
                    <td>
                        <c:url var="deleteURL" value="${Mappings.DELETE_ITEM}" >
                            <c:param name="id" value="${item.id}" />
                        </c:url>

                        <a href="${deleteURL}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
