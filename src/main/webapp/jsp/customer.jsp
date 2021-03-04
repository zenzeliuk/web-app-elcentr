<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<h2>${info}</h2>
<h2>${error}</h2>
<h3><a href="/index.jsp">GO START PAGE!</a></h3><br>

<div>
    <form action="/customer-button-create">
        <label for="name">Name:</label>
        <input id="name" type="text" name="name" required><br>

        <label for="notes">Notes:</label>
        <input id="notes" type="text" name="notes"><br>

        <button type="submit">Create</button>
    </form>
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
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
