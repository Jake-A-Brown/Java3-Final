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
    <title>Patient Login Page</title>
</head>
<body>
<h1><%="Patient Login"%>
</h1>
<form action="PatientLoginServlet">
    User Name:&nbsp;&nbsp;&nbsp; <input type="text" name="puser"/><br/>
    <br/>
    Password:&nbsp;&nbsp;&nbsp; <input type="text" name="ppass"/><br/>
    <br/>
    <input type="submit" value="Login"/>&nbsp;&nbsp;&nbsp;
    <input type="reset" value="Clear"/>
</form>
<a href="PatientApptTest.jsp"> New Appointment form</a>
<%--<a href="NewPatientForm.jsp"> New Patient form</a>--%>
</body>
</html>
