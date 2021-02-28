<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product components</title>
</head>
<body>

<h2>${messageSave}</h2>
<h2>${messageProduct}</h2>


<div>
    <form action="/product-enclosure">
        <input type="submit" value="ADD ENCLOSURES">
    </form>
</div>

<div>
    <form action="/product-customer">
        <input type="text" name="productId" value="${productId}" hidden>
        <input type="submit" value="ADD CUSTOMER">
    </form>
</div>
<div>
    <form action="/product-complex">
        <input type="text" name="productId" value="${productId}" hidden>
        <input type="submit" value="ADD RESIDENTIAL COMPLEX">
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
            <form action="/product-enclosure-delete">
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


<%--<table>--%>
<%--    Add a enclosure in product:--%>
<%--    <tr>--%>
<%--        <th>MANUFACTURE</th>--%>
<%--        <th>CODE</th>--%>
<%--        <th>NAME</th>--%>
<%--    </tr>--%>
<%--    <c:forEach items="${enclosures}" var="enclosure">--%>
<%--        <form action="/product-enclosure" , method="get">--%>
<%--            <tr>--%>
<%--                <input type="text" name="productId" value="${product.id}" hidden/>--%>
<%--                <input type="text" name="enclosureId" value="${enclosure.id}" hidden/>--%>
<%--                <td><c:out value="${enclosure.manufacturer}"/></td>--%>
<%--                <td><c:out value="${enclosure.code}"/></td>--%>
<%--                <td><c:out value="${enclosure.name}"/></td>--%>
<%--                <td>Amount:<input type="number" name="amount" size="4"></td>--%>
<%--                <td><input type="submit" value="ADD"></td>--%>
<%--            </tr>--%>
<%--        </form>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
</body>
</html>
