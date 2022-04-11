<%-- 
    Document   : showbooks
    Created on : Apr 10, 2022, 12:07:07 AM
    Author     : HoangKM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show book</title>
    </head>
    <body>
        <h1>List book below:</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    ${book}
                </c:forEach>
            </tbody>
        </table>
        <form action="index.jsp">
            <input type="submit" value="Back" />
        </form>

    </body>
</html>
