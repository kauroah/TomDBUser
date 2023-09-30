<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users</title>
</head>
<body>
<h1>Users</h1>
<ul>
    <c:forEach var="user" items="${userList}">
        <li>${user.id}: ${user.username}</li>
    </c:forEach>
</ul>
</body>
</html>
