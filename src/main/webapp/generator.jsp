<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 15.04.14
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Generator</title>
</head>
<body>
    <div id="page">
        <nav>
            <a href="${pageContext.request.contextPath}/index" title="Enterprise Company" class="logo">Company</a>
            <a href="${pageContext.request.contextPath}/generator" title="Enterprise Company" class="logo">Generator</a>
            <a href="${pageContext.request.contextPath}/employees" title="Enterprise Company" class="logo">Employees</a>
        </nav>
        ${Message}
        <p><FORM TYPE=GET ACTION=/generator>
            <INPUT TYPE=submit name=submit Value="Start generator 1">
        </FORM></p>

        <p><FORM TYPE=GET ACTION=/generator>
            <INPUT TYPE=submit name=submit Value="Start generator 2">
        </FORM></p>

        <p><FORM TYPE=GET ACTION=/employees>
            <INPUT TYPE=submit name=submit Value="employees">
        </FORM></p>
    </div>
</body>
</html>
