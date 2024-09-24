<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/18/2024
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chọn Gia Vị</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h2>Chọn Gia Vị Cho Sandwich</h2>
                </div>
                <div class="card-body">
                    <form action="save" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mời bạn chọn các gia vị:</label>
                            <div>
                                <c:forEach var="condiment" items="${condiments}">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="condiment" value="${condiment}" id="${condiment}">
                                        <label class="form-check-label" for="${condiment}">
                                                ${condiment}
                                        </label>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-success" onclick="showToast()">Chọn</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap Toast for Success Message -->
    <div class="toast-container position-fixed bottom-0 end-0 p-3">
        <div id="successToast" class="toast bg-success text-white" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <strong class="me-auto">Thông báo</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                Gia vị đã được chọn thành công!
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<!-- JavaScript to Show Toast -->
<script>
    function showToast() {
        var toastEl = document.getElementById('successToast');
        var toast = new bootstrap.Toast(toastEl);
        toast.show();
    }
</script>

</body>
</html>

