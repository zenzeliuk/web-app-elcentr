<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<h2>${messageSave}</h2>
<h2>${messageProduct}</h2>

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


<%--<div>--%>
<%--    <table>--%>
<%--        Enclosures in product:--%>
<%--        <tr>--%>
<%--            <th>MANUFACTURE</th>--%>
<%--            <th>CODE</th>--%>
<%--            <th>NAME</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${componentEnclosures}" var="enclosure">--%>
<%--            <form action="/product-enclosure-delete">--%>
<%--                <tr>--%>
<%--                    <td><c:out value="${enclosure.enclosureManufacturer}"/></td>--%>
<%--                    <td><c:out value="${enclosure.enclosureCode}"/></td>--%>
<%--                    <td><c:out value="${enclosure.enclosureName}"/></td>--%>
<%--                    <td><input type="submit" value="DELETE"></td>--%>
<%--                </tr>--%>
<%--            </form>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>

</body>
</html>
