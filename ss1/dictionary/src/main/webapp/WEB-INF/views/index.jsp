<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="/translate" method="post">
  <>Please enter English word <input type="text" name="word"></h3>
<button type="submit">Translate</button>
<h3>Your word is: ${result}</h3>
</form>
</body>
</html>