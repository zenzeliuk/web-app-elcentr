<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product components</title>
</head>
<body>

<h2>Product ${name} with code ${code} saved</h2>

<div>
    <form action="component">

    </form>
</div>

<h3>Please, select components for the product</h3>

<table>
    Add a enclosure in product:
    <tr>
        <th>MANUFACTURE</th>
        <th>CODE</th>
        <th>NAME</th>
    </tr>
    <c:forEach items="${enclosures}" var="enclosure">
        <form action="product-enclosure" , method="post">
            <tr>
                <input type="text" name="enclosureId" value="${enclosure.id}" hidden/>
                <td><c:out value="${enclosure.manufacturer}"/></td>
                <td><c:out value="${enclosure.code}"/></td>
                <td><c:out value="${enclosure.name}"/></td>
                <td><input type="number" name="amount" size="4"></td>
                <td><input type="submit" value="ADD"></td>

                    <%--                <input type="text" name="action" value="addEnclosureToProduct" hidden/>--%>
                    <%--                <input type="text" name="enclosureId" value="${enclosure.id}" hidden/>--%>
                    <%--                <input type="text" name="productId" value="${productId}" hidden/>--%>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
