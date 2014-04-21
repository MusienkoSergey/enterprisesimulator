<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 15.04.14
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simulator</title>
  </head>
  <body>
  <div id="page">
      <nav>
          <a href="${pageContext.request.contextPath}/index" title="Enterprise Company" class="logo">Company</a>
          <a href="${pageContext.request.contextPath}/generator" title="Enterprise Company" class="logo">Generator</a>
          <a href="${pageContext.request.contextPath}/employees" title="Enterprise Company" class="logo">Employees</a>
      </nav>
      <p> ${Counter}</p>
      <p>${getServerInfo}</p>
  </div>
  </body>
</html>
