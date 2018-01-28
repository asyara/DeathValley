<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>BankLists</title>
</head>
<body>
<form action="richest" method="POST">
    <p>
        <input type="text" placeholder="richest user" value="${richestUser}">
        <input type="submit" name="action" value="get"/>
    </p>
</form>

<form action="sum" method="POST">
    <p>
        <input type="text" placeholder="accounts sum" value="${sum}">
        <input type="submit" name="action" value="get"/>
    </p>
</form>
</body>
</html>
