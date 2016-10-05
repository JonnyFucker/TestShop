<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2016-10-02
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table border="1">
    <!-- column headers -->
    <tr>
        <c:forEach var="columnName" items="${cate}">
            <th><c:out value="${columnName.name}"/></th>
        </c:forEach>
    </tr>
    <!-- column data -->
<%--    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
            <c:forEach var="column" items="${row}">
                <td><c:out value="${column}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>--%>
</table>
</body>
</html>
