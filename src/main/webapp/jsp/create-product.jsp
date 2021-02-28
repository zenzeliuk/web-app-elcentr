<html>
<head>
    <title>Creation page</title>
</head>
<body>

<h2>${error}</h2>

<br>
<h3><a href="/index.jsp">GO START PAGE!</a></h3><br>

<form action="/create-product" method="get">

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