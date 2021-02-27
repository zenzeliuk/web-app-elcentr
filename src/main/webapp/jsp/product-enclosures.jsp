<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add product enclosures</title>
</head>
<body>
<h2>${messageInfoProduct}</h2>
<div>
    <form action="/product-component">
        <input type="text" name="productId" value="${productId}" hidden>
        <input type="submit" value="GO BACK">
    </form>
</div>
<div>
    <table>
        Enclosures in product:
        <tr>
            <th>MANUFACTURE</th>
            <th>CODE</th>
            <th>NAME</th>
        </tr>
        <c:forEach items="${componentEnclosures}" var="enclosure">
            <form action="/product-enclosure-delete" , method="get">
                <tr>
                    <td><c:out value="${enclosure.enclosureManufacturer}"/></td>
                    <td><c:out value="${enclosure.enclosureCode}"/></td>
                    <td><c:out value="${enclosure.enclosureName}"/></td>
                    <td><input type="submit" value="DELETE"></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</div>

</body>
</html>
