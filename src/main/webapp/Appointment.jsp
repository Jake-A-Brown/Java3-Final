<%--
  Created by IntelliJ IDEA.
  User: loucr
  Date: 5/2/2023
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Appointment</title>
</head>
<body>

<form action="NewPatientServlet" method="post">
    Appointment Time:<br/>
    <input name="DateTime" type="text"><br/>
    Patient I.D.:<br/>
    <input name="PatientId" type="text"><br/>
    Dentist I.D.:<br/>
    List of Dentist <br/>
    D201, D202, D203, or D204<br/>
    <input name="DentId" type="text"><br/>
    Procedure Code:<br/>
    <input name="ProcCode" type="text"><br/>

    <input name="InsertBtn" type="submit" value="Insert">
    <input name="ClearBtn" type="reset" value="Clear">
</form>

</body>
</html>
