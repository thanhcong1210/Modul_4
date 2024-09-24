
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/18/2024
  Time: 2:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
    <!-- Thêm Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Settings</h1>
    <p style="color: blue">${message}</p>

    <!-- Sử dụng class 'form-horizontal' cho form đẹp hơn -->
    <form:form modelAttribute="emailList" method="post" class="form-horizontal">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Language :</label>
            <div class="col-sm-10">
                <form:select path="language" items="${language}" class="form-control"></form:select>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Page Size :</label>
            <div class="col-sm-10">
                Show <form:select path="pageSize" items="${size}" class="form-control d-inline-block w-auto"></form:select> emails per page
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Spams Filter :</label>
            <div class="col-sm-10">
                <form:checkbox path="spamsFilter" class="mr-2"></form:checkbox> Enable spams filter
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Signature</label>
            <div class="col-sm-10">
                <form:textarea path="signature" class="form-control" rows="3"></form:textarea>
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-10 offset-sm-2">
                <form:button type="submit" class="btn btn-primary mr-2">Update</form:button>
                <form:button type="button" class="btn btn-secondary">Cancel</form:button>
            </div>
        </div>
    </form:form>
</div>

<!-- Thêm Bootstrap JS và các thư viện liên quan -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
