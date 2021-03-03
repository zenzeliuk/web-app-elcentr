<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<h2>${messageSave}</h2>
<h2>${infoProduct}</h2>

<div>
    <form action="/product-enclosure">
        <input type="submit" value="ENCLOSURES">
    </form>
</div>

<div>
    <form action="/product-order">
        <input type="submit" value="ORDER">
    </form>
</div>

</body>
</html>
