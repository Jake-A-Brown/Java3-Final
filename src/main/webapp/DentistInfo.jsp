<%@ page import="com.example.dentist.AppointmentListBOPack.AppointmentListBO" %>
<%@ page import="com.example.dentist.PatientBOPack.PatientBO" %>
<%@ page import="com.example.dentist.DentistBOPack.DentistBO" %>
<%@ page import="com.example.dentist.AppointmentBOPack.AppointmentBO" %>
<%--
  Created by IntelliJ IDEA.
  User: loucr
  Date: 3/15/2023
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table, th, td {
            border: 2px solid black;
        }
    </style>
    <title>Dentist Page</title>
</head>
<body>
<%PatientBO p1 = (PatientBO) session.getAttribute("p1"); %>
<%AppointmentBO a1 = (AppointmentBO) session.getAttribute("a1");%>
<%DentistBO d1 = (DentistBO) session.getAttribute("d1");%>

<h1>Welcome</h1>
<form action="DentistServlet" method="post">
    First Name:<br/>
    <input name="dfntext" type="text"/><br/>
    Last Name:<br/>
    <input name="dlastname" type="text"/><br/>
    E-Mail:<br/>
    <input name="demail" type="text"/><br/>
    Office Number:<br/>
    <input name="dofficenum" type="text"/>
    <%--    <input type="hidden" name="action" value="update">--%>
    <%--<input name="InputBtn" type="button" value="Input" />--%>
    <input name="UpdateBtn" type="submit" value="Update"/>
    <%--<input name="DeleteBtn" type="button" value="Delete" />--%>
    <input name="ClearBtn" type="reset" value="Clear"/>
</form>

<form>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Office Number</th>
            <%--        <th>Procedure</th>--%>
        </tr>

        <tr>
            <td><%=d1.getDfn()%>
            </td>
            <td><%=d1.getDln()%>
            </td>
            <td><%=d1.getDemail()%>
            </td>
            <td><%=d1.getDoffice()%>
            </td>
        </tr>
    </table>
</form>

<h2>A list of Appointments for <%=d1.getDfn()%>
</h2>

<form>
    <table>
        <tr>
            <th>Apointment Time</th>
            <th>Patient I.D.</th>
            <th>Dentist I.D.</th>
            <th>Procedure Code</th>
        </tr>
        <%
            AppointmentListBO a = d1.getAppt();
            AppointmentBO[] s = a.displayAllAppointments();
            for (int i = 0; i < s.length; i++) {
        %>

        <tr>
            <td><%=s[i].getADatetime()%>
            </td>
            <td><%=s[i].getAPatid()%>
            </td>
            <td><%=s[i].getADentid()%>
            </td>
            <td><%=s[i].getAprocCode()%>
            </td>
        </tr>
        <%}%>
    </table>
</form>

</body>
</html>
