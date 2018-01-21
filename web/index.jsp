<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BankLists</title>
</head>
<body>
<form action="AppServlet" method="POST">
    <p>
        <input type="text" value="${richestUser}">
        <input type="submit" name="action" value="getRichestUser"/>
    </p>
    <p>
        <input type="text" value="${summa}">
        <input type="submit" name="action" value="getSum"/>
    </p>
</form>
</body>
</html>
