<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product enclosures</title>
</head>
<body>

<h2>${infoProduct}</h2>

<div>
    <form action="/product">
        <input type="submit" value="GO BACK">
    </form>
</div>

<div>
    <table>
        <h2>Enclosures in product:</h2>
        <tr>
            <th>MANUFACTURE</th>
            <th>CODE</th>
            <th>NAME</th>
            <th>AMOUNT</th>
        </tr>
        <c:forEach items="${productEnclosures}" var="productEnclosure">
            <form action="/product-enclosure-button-delete">
                <tr>
                    <input type="text" name="componentId" value="${productEnclosure.componentId}" hidden>
                    <input type="text" name="productId" value="${productId}" hidden>
                    <td><c:out value="${productEnclosure.enclosureManufacturer}"/></td>
                    <td><c:out value="${productEnclosure.enclosureCode}"/></td>
                    <td><c:out value="${productEnclosure.enclosureName}"/></td>
                    <td><c:out value="${productEnclosure.enclosureAmount}"/></td>
                    <td><input type="submit" value="DELETE"></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</div>
<br>

<div>
    <form action="/enclosure-button-create">
        <h2>Create enclosures:</h2>

        <input type="text" name="productId" value="${productId}" hidden>

        <label for="manufacture">MANUFACTURE:</label>
        <input id="manufacture" type="text" name="manufacture">

        <label for="code">CODE:</label>
        <input id="code" type="text" name="code">

        <label for="name">NAME:</label>
        <input id="name" type="text" name="name" required>

        <input type="submit" value="CREATE">
    </form>
</div>
<br>

<div>
    <table>
        <h3>List enclosures:</h3>
        <tr>
            <th>MANUFACTURE</th>
            <th>CODE</th>
            <th>NAME</th>
            <th>AMOUNT</th>
        </tr>
        <c:forEach items="${enclosures}" var="enclosure">
            <form action="/product-enclosure-button-add">
                <tr>
                    <input type="text" name="enclosureId" value="${enclosure.id}" hidden>
                    <input type="text" name="productId" value="${productId}" hidden>
                    <td><c:out value="${enclosure.manufacturer}"/></td>
                    <td><c:out value="${enclosure.code}"/></td>
                    <td><c:out value="${enclosure.name}"/></td>
                    <td><input type="number" name="amount" min="1" required></td>
                    <td><input type="submit" value="ADD"></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</div>

</body>
</html>
