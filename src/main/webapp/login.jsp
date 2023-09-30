<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
  Username: <input type="text" name="username" required><br>
  Password: <input type="password" name="password" required><br>
  <input type="submit" value="Login">
</form>

<c:if test="${not empty errorMessage}">
  <p style="color: red;">${errorMessage}</p>
</c:if>
</body>
</html>
