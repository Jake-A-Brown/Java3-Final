<%--
  Created by IntelliJ IDEA.
  User: loucr
  Date: 3/11/2023
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dentist Login Page</title>
</head>
<body>
<h1><%="Dentist Login"%>
</h1>
<form action="DentistLoginServlet">
    User Name:&nbsp;&nbsp;&nbsp; <input type="text" name="DUser"/><br/>
    <br/>
    Password:&nbsp;&nbsp;&nbsp; <input type="text" name="DPsswd"/><br/>
    <br/>
    <input name="LoginBtn" type="submit" value="Login"/>&nbsp;&nbsp;&nbsp;
    <input name="ClearBtn" type="reset" value="Clear"/>
</form>

</body>
</html>
