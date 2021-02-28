<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h2>Order information.</h2><br>
    <h3>${nameCustomerInOrder}</h3><br>
    <h3>${nameComplexInOrder}</h3><br>

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
