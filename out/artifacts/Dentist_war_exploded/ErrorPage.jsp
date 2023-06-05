<%@ page import="static java.io.FileDescriptor.out" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.example.dentistappointment.PatientBOpack.PatientBO" %>
<%--
  Created by IntelliJ IDEA.
  User: loucr
  Date: 2/9/2023
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h1>Emotional Damage!</h1>
<img src="emo.jpg">

<form>
    <jsp:useBean id="p1"  scope="session" class="com.example.dentistappointment.PatientBOpack.PatientBO"/>

    <div>Patient I.D.:</div> <%= p1.getPid() %><br><br>
    <div>Patient Password is Invalid!</div>
</form>
</body>
</html>
