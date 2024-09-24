<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/17/2024
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>MONEY CONVERSION</h1>
    <form action="result" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail" class="form-label">USD :</label>
            <input type="number" class="form-control" id="exampleInputEmail" style="width: 300px" name="usd" aria-describedby="emailHelp" placeholder="USD">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword" class="form-label">Amount :</label>
            <input type="number" class="form-control" id="exampleInputPassword" style="width: 300px" name="amount">
        </div>
        <button type="submit" class="btn btn-primary">Convert</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
