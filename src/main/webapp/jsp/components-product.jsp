<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Components</title>
</head>
<body>
<h2><c:out value="Product ${name} with code ${code} saved"/></h2>

<h3>Please, select components for the product</h3>

<table>
    Add a enclosure in product:
    <tr>
        <th>MANUFACTURE</th>
        <th>CODE</th>
        <th>NAME</th>
    </tr>
    <c:forEach items="${enclosures}" var="enclosure">
        <form action="component", method="get">
            <tr>
                <input type="text" name="action" value="addEnclosureToProduct" hidden/>
                <input type="text" name="enclosureId" value="${enclosure.id}" hidden/>
                <input type="text" name="productId" value="${productId}" hidden/>
                <td><c:out value="${enclosure.manufacturer}"/></td>
                <td><c:out value="${enclosure.code}"/></td>
                <td><c:out value="${enclosure.name}"/></td>
                <td><input type="text" name="amount" size="3"></td>
                <td><input type="submit" value="ADD"></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
