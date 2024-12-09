<%@ page import="com.demo.main.utils.RoleEnum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <title>注册</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/lib/bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/lib/bootstrap-5.3.0-alpha1-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .container-fluid {
            background-color: #ccc;
        }

        .center-div {
            margin-top: -100px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="w-100 h-100 d-flex justify-content-center align-items-center">
        <div class="center-div col-lg-4 h-auto card p-4 g-5">
            <h4 class="text-center">学生管理系统</h4>
            <form action="register" method="post" class="row mt-3">
                <div class="mb-3 row">
                    <div class="form-check form-check-inline col-lg-3 me-0 ms-2">
                        <input type="radio" id="student-role" name="role" class="form-check-input" value="<%=RoleEnum.STUDENT%>" checked readonly>
                        <label for="student-role">学生</label>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="username-input" class="col-lg-3 col-form-label">用户名</label>
                    <div class="col-lg-9">
                        <input type="text" id="username-input" name="username" class="form-control"
                               placeholder="用户名">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="password-input" class="col-lg-3 col-form-label">密码</label>
                    <div class="col-lg-9">
                        <input type="password" id="password-input" name="password" class="col-lg-10 form-control"
                               placeholder="密码">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="name-input" class="col-lg-3 col-form-label">姓名</label>
                    <div class="col-lg-9">
                        <input type="text" id="name-input" name="name" class="col-lg-10 form-control"
                               placeholder="姓名">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="age-input" class="col-lg-3 col-form-label">年龄</label>
                    <div class="col-lg-9">
                        <input type="number" id="age-input" name="age" class="col-lg-10 form-control"
                               placeholder="年龄">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="gender-input" class="col-lg-3 col-form-label">性别</label>
                    <div class="col-lg-9">
                        <input type="text" id="gender-input" name="gender" class="col-lg-10 form-control"
                               placeholder="性别">
                    </div>
                </div>
                <div class="mt-4 ps-3 row">
                    <button type="submit" class="btn btn-primary col-2">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
