<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Creation page</title>
</head>
<body>
<h2>${error}</h2>
<h3><a href="/index.jsp">GO START PAGE!</a></h3>

<form action="/create-product">

    <label for="name">Name product:</label>
    <input id="name" type="text" name="name" required><br>

    <label for="amount">Amount:</label>
    <input id="amount" type="number" name="amount" min="1" required><br>

    <label for="current">Nominal current:</label>
    <input id="current" type="number" name="current" min="0" max="6300" required><br>

    <label for="decimal">Decimal number:</label>
    <input id="decimal" type="text" name="decimal"><br>

    <button type="submit">Create</button>

</form>
</body>
</html>