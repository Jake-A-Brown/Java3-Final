<%@ page import="com.example.dentist.PatientBOPack.PatientBO" %><%--
  Created by IntelliJ IDEA.
  User: loucr
  Date: 3/17/2023
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Patient form</title>
</head>
<body>
<%PatientBO p1 = (PatientBO) session.getAttribute("p1"); %>
<form action="AppointmentServlet" method="post">
    I.D.:<br/>
    <input name="IdTextBox" type="text"/><br/>
    Password:<br/>
    <input name="PsswdTextBox" type="text"/><br/>
    First Name:<br/>
    <input name="FNTextBox" type="text"/><br/>
    Last Name:<br/>
    <input name="LNTextBox" type="text"/><br/>
    Address:<br/>
    <input name="AddyTextBox" type="text"/><br/>
    Email:<br/>
    <input name="EmailTextBox" type="text"/><br/>
    Insurance Company:<br/>
    <input name="InsCoTextBox" type="text"/><br/>

    <input name="InsertBtn" type="submit" value="Insert"/>
    <%--    <input name="UpdateBtn" type="button" value="Update" />--%>
    <input name="ClearBtn" type="reset" value="Clear"/>
</form>

<form></form>
<%--<a href="PatientLogin.jsp"> Back to Patient Login</a>--%>
</body>
</html>
