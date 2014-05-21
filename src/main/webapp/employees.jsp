<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 15.04.14
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
    <div id="page">
        <nav>
            <a href="${pageContext.request.contextPath}/index" title="Enterprise Company" class="logo">Company</a>
            <a href="${pageContext.request.contextPath}/generator" title="Enterprise Company" class="logo">Generator</a>
            <a href="${pageContext.request.contextPath}/employees" title="Enterprise Company" class="logo">Employees</a>
        </nav>
        <table>
            <tr>
                <td>
                    <FORM TYPE=GET ACTION=/employees>
                        <INPUT TYPE=submit name=sorting Value="Sorting By Surname">
                    </FORM>
                </td>
                <td>
                    <FORM TYPE=GET ACTION=/employees>
                        <INPUT TYPE=submit name=sorting Value="Sorting By Date Of Birth">
                    </FORM>
                </td>
                <td>
                    <FORM TYPE=GET ACTION=/employees>
                        <INPUT TYPE=submit name=sorting Value="Sorting By Salary">
                    </FORM>
                </td>
            </tr>
            <c:forEach items="${AllEmployees}"  var = "employee">
                <tr>
                    <td>
                            ${employee.getSurname()}
                    </td>
                    <td>
                            ${employee.getDateOfBirth()}
                    </td>
                    <td>
                            ${employee.getSalary()}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
