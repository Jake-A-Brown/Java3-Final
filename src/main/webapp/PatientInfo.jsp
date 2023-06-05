<%--
  Created by IntelliJ IDEA.
  User: loucr
  Date: 3/13/2023
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static java.io.FileDescriptor.out" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.example.dentist.PatientBOPack.PatientBO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.dentist.AppointmentBOPack.AppointmentBO" %>
<%@ page import="com.example.dentist.AppointmentListBOPack.AppointmentListBO" %>
<%@ page import="com.example.dentist.DentistBOPack.DentistBO" %>
<html>
<head>
    <style>
        table, th, td {
            border: 2px solid black;
        }
    </style>
    <title>Patient Info</title>
</head>
<body>
<%PatientBO p1 = (PatientBO) session.getAttribute("p1"); %>
<%AppointmentBO a1 = (AppointmentBO) session.getAttribute("a1");%>
<%DentistBO d1 = (DentistBO) session.getAttribute("d1");%>
<h1><%="Welcome "%><%=p1.getPfn()%>
</h1>
<form action="PatientServlet" method="post">
    First Name:<br/>
    <input name="PFNTextBox" type="text"/><br/>
    Last Name:<br/>
    <input name="PLNTextBox" type="text"/><br/>
    Address:<br/>
    <input name="PAddyTextBox" type="text"/><br/>
    E-Mail:<br/>
    <input name="PEmailTextBox" type="text"/><br/>
    <%--    Procedure:<br />--%>
    <%--    <input name="PProcTextBox" type="text" /><br />--%>
    <%--    <br />--%>


    <%--    <input name="InputBtn" type="button" value="Input" />--%>
    <input name="UpdateBtn" type="submit" value="Update"/>
    <%--    <input name="DeleteBtn" type="button" value="Delete" />--%>
    <input name="ClearBtn" type="reset" value="Clear"/>
</form>
<a href="PatientApptTest.jsp"> New Appointment form</a>
<br/>
<form>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>E-Mail</th>
            <%--        <th>Procedure</th>--%>
        </tr>

        <tr>
            <td><%=p1.getPfn()%>
            </td>
            <td><%=p1.getPln()%>
            </td>
            <td><%=p1.getPaddy()%>
            </td>
            <td><%=p1.getPemail()%>
            </td>
        </tr>
    </table>
</form>

<h2>Appointment Information:</h2><br/>
<%--    <input name="PApptTextBox" type="text" /><br />--%>
<form>
    <table>
        <tr>
            <th>Appointment Date</th>
            <th>Dentist</th>
            <th>Procedure</th>
        </tr>

        <tr>
            <td><%=a1.getADatetime()%>
            </td>
            <th><%=a1.getADentid()%>
            </th>
            <th><%=a1.getAprocCode()%>
            </th>
        </tr>
    </table>
</form>

<form action="AppointmentUpdateServlet" method="post">
    Appointment Time:<br/>
    <input name="Datetime" type="text"><br/>
    Patient I.D.:<br/>
    <input name="Patientid" type="text"><br/>
    Dentist I.D.:<br/>
    List of Dentist <br/>
    D201, D202, D203, or D204<br/>
    <input name="Dentid" type="text"><br/>
    Procedure Code:<br/>
    <input name="Proccode" type="text"><br/>

    <input name="UpdateBtn" type="submit" value="Update">
    <input name="ClearBtn" type="reset" value="Clear">
</form>

</body>
</html>
