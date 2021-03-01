<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product customer</title>
</head>
<body>

<h2>${messageProduct}</h2>

<div>
    <form action="/product">
        <input type="submit" value="GO BACK">
    </form>
</div>

<div>
    <c:forEach items="${orderDTO}" var="order">
        <h1>
            Customer: <c:out value="${order.customerName}"/>
        </h1>
        <h1>
            Residential complex: <c:out value="${order.complexName}"/>,
            at the address: <c:out value="${order.complexAddress}"/>
        </h1>
        <br>
    </c:forEach>
</div>
<br>
<div>
    <table>
        <h2>Customer list</h2>
        <tr>
            <th>NAME</th>
            <th>NOTES</th>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <input type="text" name="customerId" value="${customer.id}" hidden>
                <input type="text" name="productId" value="${productId}" hidden>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.notes}"/></td>
                <td><input type="submit" value="SELECT"></td>
            </tr>
        </c:forEach>
    </table>
</div>


<%--<div>--%>
<%--    <table>--%>
<%--        <h2>Enclosures in product:</h2>--%>
<%--        <tr>--%>
<%--            <th>MANUFACTURE</th>--%>
<%--            <th>CODE</th>--%>
<%--            <th>NAME</th>--%>
<%--            <th>AMOUNT</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${componentEnclosures}" var="component">--%>
<%--            <form action="/product-enclosure-button-delete">--%>
<%--                <tr>--%>
<%--                    <input type="text" name="componentId" value="${component.componentId}" hidden>--%>
<%--                    <input type="text" name="productId" value="${productId}" hidden>--%>
<%--                    <td><c:out value="${component.enclosureManufacturer}"/></td>--%>
<%--                    <td><c:out value="${component.enclosureCode}"/></td>--%>
<%--                    <td><c:out value="${component.enclosureName}"/></td>--%>
<%--                    <td><c:out value="${component.enclosureAmount}"/></td>--%>
<%--                    <td><input type="submit" value="DELETE"></td>--%>
<%--                </tr>--%>
<%--            </form>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>


</body>
</html>
