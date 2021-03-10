<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<h2>${info}</h2>

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

<div>
    <table>
        <h3>List customers:</h3>
        <tr>
            <th>NAME</th>
            <th>NOTES</th>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.notes}"/></td>
                <c:if test="${order != null}">
                    <form action="/product-customer-add-button">
                        <input type="text" name="customerId" value="${customer.id}" hidden>
                        <td><input type="submit" value="ADD IN PRODUCT"></td>
                    </form>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
    <table>
        <h3>List complexes:</h3>
        <tr>
            <th>NAME</th>
            <th>ADDRESS</th>
        </tr>
        <c:forEach items="${complexes}" var="complex">
            <tr>
                <td><c:out value="${complex.name}"/></td>
                <td><c:out value="${complex.address}"/></td>
                <c:if test="${order != null}">
                    <form action="/product-complex-button-add">
                        <input type="text" name="complexId" value="${complex.id}" hidden>
                        <td><input type="submit" value="ADD IN PRODUCT"></td>
                    </form>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
