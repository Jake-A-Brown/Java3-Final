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
    <title>Dentist Page</title>
</head>
<body>
<h1><%="Welcome "%></h1>
<form>
    First Name:<br />
    <input name="dfntext" type="text"  /><br />
    Last Name:<br />
    <input name="dlastname" type="text" /><br />
    E-Mail:<br />
    <input name="demail" type="text" /><br />
    Office Number:<br />
    <input name="dofficenum" type="text" />
</form>

<%--<input name="InputBtn" type="button" value="Input" />--%>
<input name="UpdateBtn" type="button" value="Update" />
<%--<input name="DeleteBtn" type="button" value="Delete" />--%>
<input name="ClearBtn" type="reset" value="Clear" />
</body>
</html>
