<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products</title>
</head>
<body>

<table>
    Products:
    <tr>
        <th>ITEM CODE</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>INIT PRICE</th>
        <th>AMOUNT</th>
        <th>BUY</th>
    </tr>
    <c:forEach items="${products}" var="products">
        <form action="order-item", method="post">
            <tr>
                <input type="text" name="action" value="addToCart" hidden/>
                <input type="text" name="userId" value="${userId}" hidden/>
                <input type="text" name="itemId" value="${item.id}" hidden/>
                <td><c:out value="${item.itemCode}"/></td>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.price}"/></td>
                <td><c:out value="${item.initPrice}"/></td>
                <td><input type="text" name="amount" size="5"></td>
                <td><input type="submit" value="BUY"></td>
            </tr>
        </form>
    </c:forEach>
</table>

</body>
</html>
