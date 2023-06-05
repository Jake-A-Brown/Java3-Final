<%--
  Created by IntelliJ IDEA.
  User: loucr
  Date: 3/13/2023
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static java.io.FileDescriptor.out" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.example.dentistappointment.PatientBOpack.PatientBO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.dentistappointment.AppointmentBOpack.AppointmentBO"%>
<html>
<head>
    <style>
        table, th, td {
            border:2px solid black;
        }
    </style>
    <title>Patient Info</title>
</head>
<body>
<%PatientBO p1=(PatientBO)session.getAttribute("p1"); %>
<%AppointmentBO a1 =(AppointmentBO)session.getAttribute("a1");%>
<h1><%="Welcome "%><%=p1.getPfn()%></h1>
<form action="/PatientServlet">
    First Name:<br />
    <input name="PFNTextBox" type="text" /><br />
    Last Name:<br />
    <input name="PLNTextBox" type="text" /><br />
    Address:<br />
    <input name="PAddyTextBox" type="text" /><br />
    E-Mail:<br />
    <input name="PEmailTextBox" type="text" /><br />
    Procedure:<br />
    <input name="PProcTextBox" type="text" /><br />
    <br />

    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>E-Mail</th>
            <%--        <th>Procedure</th>--%>
        </tr>

        <tr>
            <td><%=p1.getPfn()%></td>
            <td><%=p1.getPln()%></td>
            <td><%=p1.getPaddy()%></td>
            <td><%=p1.getPemail()%></td>

            <%--        <td><%=a1.get%></td>--%>
        </tr>
    </table>

    <%--    <input name="InputBtn" type="button" value="Input" />--%>
    <input name="UpdateBtn" type="button" value="Update" />
    <%--    <input name="DeleteBtn" type="button" value="Delete" />--%>
    <input name="ClearBtn" type="reset" value="Clear" />
</form>

<form action="/AppointmentServlet">
    Appointment Date:<br />
    <input name="PApptTextBox" type="text" /><br />

    <table>
        <tr>
            <th>Appointment time</th>
        </tr>

        <tr>
            <td><%=a1.getADatetime()%></td>
        </tr>
    </table>
</form>
</body>
</html>
