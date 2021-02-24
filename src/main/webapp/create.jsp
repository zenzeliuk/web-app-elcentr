<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Creation page</title>
</head>

<body>
<h2><c:out value="${error}"/></h2>

<br><h3><a href="/index.jsp">GO START PAGE!</a></h3><br>

<form action="create" method="post">

    <label for="name">Name product:</label>
    <input id="name" type="text" name="name" required>

    <label for="amount">Amount:</label>
    <input id="amount" type="number" name="amount" min="1" max="1000" required>

    <label for="current">Nominal current:</label>
    <input id="current" type="number" name="current" min="0" max="6300" required>

    <label for="decimal">Decimal number:</label>
    <input id="decimal" type="text">

    <input type="submit" value="Create">

</form>
</body>
</html>