<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product enclosures</title>
</head>
<body>
<h2>${info}</h2>

<div>
    <form action="/product">
        <input type="submit" value="GO BACK">
    </form>
</div>
<c:if test="${productEnclosures != null}">
    <div>
        <table>
            <h2>Enclosures in product:</h2>
            <tr>
                <th>MANUFACTURE</th>
                <th>CODE</th>
                <th>NAME</th>
                <th>AMOUNT</th>
            </tr>
            <c:forEach items="${productEnclosures}" var="productEnclosure">
                <tr>
                    <td><c:out value="${productEnclosure.manufacturer}"/></td>
                    <td><c:out value="${productEnclosure.code}"/></td>
                    <td><c:out value="${productEnclosure.name}"/></td>
                    <td><c:out value="${productEnclosure.amount}"/></td>
                    <form action="/product-enclosure-button-delete">
                        <input type="text" name="productEnclosureId" value="${productEnclosure.id}" hidden>
                        <td><input type="submit" value="DELETE"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>

<div>
    <table>
        <h3>List enclosures:</h3>
        <tr>
            <th>MANUFACTURE</th>
            <th>CODE</th>
            <th>NAME</th>
            <th>AMOUNT</th>
        </tr>
        <c:forEach items="${enclosures}" var="enclosure">
            <tr>
                <td><c:out value="${enclosure.manufacturer}"/></td>
                <td><c:out value="${enclosure.code}"/></td>
                <td><c:out value="${enclosure.name}"/></td>

                <c:if test="${productEnclosures != null}">
                    <form action="/product-enclosure-button-add">
                        <input type="text" name="enclosureId" value="${enclosure.id}" hidden>
                        <td><input type="number" name="amount" min="1" required></td>
                        <td><input type="submit" value="ADD IN PRODUCT"></td>
                    </form>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
