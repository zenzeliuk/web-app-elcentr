<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h2>${info}</h2>

<div>
    <form action="/enclosures">
        <input type="submit" value="ENCLOSURES">
    </form>
</div>

<div>
    <form action="/order">
        <input type="submit" value="ORDER">
    </form>
</div>


<div>
    <table>
        <h3>List products:</h3>
        <tr>
            <th>NAME</th>
            <th>CODE</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <form action="/product-edit">
                <tr>
                    <input type="text" name="productId" value="${product.id}" hidden>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.code}"/></td>
                    <td><input type="submit" value="EDIT"></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</div>

</body>
</html>
