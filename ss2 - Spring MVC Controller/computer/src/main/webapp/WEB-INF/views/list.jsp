<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/18/2024
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }
        .card-header {
            background-color: #4a90e2;
        }
        .btn-custom {
            background-color: #5bc0de;
            color: white;
        }
        .btn-custom:hover {
            background-color: #31b0d5;
            color: white;
        }
    </style>
</head>

<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header text-white text-center">
                    <h2>Simple Calculator</h2>
                </div>
                <div class="card-body">
                    <form action="" method="post">
                        <div class="mb-3">
                            <label for="first" class="form-label">First Number</label>
                            <input type="number" class="form-control" id="first" name="first" placeholder="Enter first number"  step="any">
                        </div>
                        <div class="mb-3">
                            <label for="second" class="form-label">Second Number</label>
                            <input type="number" class="form-control" id="second" name="second" placeholder="Enter second number"  step="any">
                        </div>
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-custom" value="+" name="item">Addition ( + )</button>
                            <button type="submit" class="btn btn-custom" value="-" name="item">Subtraction ( - )</button>
                            <button type="submit" class="btn btn-custom" value="*" name="item">Multiplication ( * )</button>
                            <button type="submit" class="btn btn-custom" value="/" name="item">Division ( / )</button>
                        </div>
                    </form>
                </div>
                <div class="card-footer text-center">
                    <h4>Result: <span id="result">${result}</span></h4>
                    <c:if test="${not empty error}">
                        <h6 style="color: red">${error}</h6>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
