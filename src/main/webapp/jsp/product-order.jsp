<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product customer</title>
</head>
<body>

<h2>${infoProduct}</h2>

<div>
    <form action="/product">
        <input type="submit" value="GO BACK">
    </form>
</div>

<div>
    <c:if test="${order.customerName != null}">
        <h2>Customer: ${order.customerName}</h2>
    </c:if>
    <c:if test="${order.complexName != null}">
        <h2>Complex: ${order.complexName}</h2>
    </c:if>
    <c:if test="${order.complexAddress != null}">
        <h2>Address: ${order.complexAddress}</h2>
    </c:if>
</div>


<%--<form action="product-customer-delete">--%>
<%--    <h2>${productCustomer}</h2>--%>
<%--    <input type="submit" value="DELETE">--%>
<%--</form>--%>


<%--<div>--%>
<%--    <c:forEach items="${orderDTO}" var="order">--%>
<%--        <h1> Customer: <c:out value="${order.customerName}"/></h1>--%>
<%--    </c:forEach>--%>
<%--</div>--%>
<%--    <c:forEach items="${orderDTO}" var="order">--%>
<%--        <h1> Residential complex: <c:out value="${order.complexName}"/>, <c:out value="${order.complexAddress}"/></h1>--%>
<%--    </c:forEach>--%>
<%--</div>--%>


<%--<br>--%>
<%--<div>--%>
<%--    <table>--%>
<%--        <h2>Customer list</h2>--%>
<%--        <tr>--%>
<%--            <th>NAME</th>--%>
<%--            <th>NOTES</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${customers}" var="customer">--%>
<%--            <tr>--%>
<%--                <input type="text" name="customerId" value="${customer.id}" hidden>--%>
<%--                <input type="text" name="productId" value="${productId}" hidden>--%>
<%--                <td><c:out value="${customer.name}"/></td>--%>
<%--                <td><c:out value="${customer.notes}"/></td>--%>
<%--                <td><input type="submit" value="SELECT"></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>

</body>
</html>
