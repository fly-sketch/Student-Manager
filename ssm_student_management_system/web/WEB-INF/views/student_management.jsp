<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.demo.main.utils.PermissionUtil" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.main.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <title>学生管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/lib/bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <script src="${pageContext.request.contextPath}/lib/bootstrap-5.3.0-alpha1-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.min.js"></script>
</head>
<%
    Map<String, String> linksMap = (Map<String, String>) request.getAttribute("links");
    List<Student> list = (List<Student>) request.getAttribute("list");
%>
<body>
<div class="container-fluid">
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">添加</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form class="model-form" action="${pageContext.request.contextPath}/student/add">
                        <input type="hidden" name="id" value="">
                        <div class="mb-3 row">
                            <label class="col-lg-3 col-form-label">用户名</label>
                            <div class="col-lg-9">
                                <input type="text" name="username" class="form-control" placeholder="用户名" value="">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-lg-3 col-form-label">密码</label>
                            <div class="col-lg-9">
                                <input type="text" name="password" class="form-control" placeholder="密码" value="">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-lg-3 col-form-label">姓名</label>
                            <div class="col-lg-9">
                                <input type="text" name="name" class="form-control" placeholder="姓名" value="">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-lg-3 col-form-label">年龄</label>
                            <div class="col-lg-9">
                                <input type="number" name="age" class="form-control" placeholder="年龄" value="">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-lg-3 col-form-label">性别</label>
                            <div class="col-lg-9">
                                <input type="text" name="gender" class="form-control" placeholder="性别" value="">
                            </div>
                        </div>
                        <button type="submit" class="model-submit-btn btn btn-primary">添加</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

                </div>
            </div>
        </div>
    </div>
    <nav class="top-nav navbar bg-body-secondary row">
        <div class="row">
            <div class="nav-content-left col-lg-2 offset-lg-1">
                <span class="navbar-brand mb-0 h1">学生管理系统</span>
            </div>
            <div class="nav-content-right row col-lg-3 offset-lg-6">
                <p class="col-lg-5">用户：<span><%=session.getAttribute(PermissionUtil.USERNAME)%></span></p>
                <p class="col-lg-auto">角色：<span><%=session.getAttribute(PermissionUtil.ROLE)%></span></p>
            </div>
        </div>
    </nav>
    <div class="non-top-nav row">
        <div class="sidebar col-lg-2 bg-body-tertiary p-3">
            <ul class="nav flex-column">
                <c:forEach var="link" items="<%=linksMap.entrySet()%>">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}${link.value}" class="nav-link">${link.key}</a>
                    </li>
                </c:forEach>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/logout" class="nav-link">退出登录</a>
                </li>
            </ul>
        </div>
        <div class="main col-lg-10 p-3 pt-4">
            <form action="${pageContext.request.contextPath}/student/management_condition" class="row" method="get">
                <div class="row">
                    <label for="username-input" class="col-auto col-form-label pe-0">姓名</label>
                    <div class="col-lg-2">
                        <input type="text" id="username-input" name="name" class="form-control" placeholder="姓名"
                               value="">
                    </div>
                    <button type="submit" class="btn btn-primary col-lg-auto">查询</button>
                    <button type="button" class="modal-add-btn btn btn-primary col-lg-auto ms-3"
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModal">
                        添加
                    </button>
                </div>
            </form>
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">用户名</th>
                    <th scope="col">姓名</th>
                    <th scope="col">年龄</th>
                    <th scope="col">性别</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="<%=list%>">
                    <tr>
                        <th scope="col">${item.id}</th>
                        <td>${item.username}</td>
                        <td>${item.name}</td>
                        <td>${item.age}</td>
                        <td>${item.gender}</td>
                        <td class="operation-col">
                            <div class="p-2 pt-0 pb-0 d-flex justify-content-between">
                                <a href="javascript:void(0)" class="edit-btn d-block btn btn-primary btn-sm"
                                   data-id="${item.id}"
                                   data-bs-toggle="modal"
                                   data-bs-target="#exampleModal"
                                >
                                    编辑
                                </a>
                                <a href="${pageContext.request.contextPath}/student/delete?id=${item.id}"
                                   class="delete-btn d-block btn btn-danger btn-sm">删除</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script>
    var editButtons = document.querySelectorAll('.edit-btn'),
        modelForm = document.querySelector('.model-form'),
        submitBtn = document.querySelector('.model-submit-btn'),
        addBtn = document.querySelector(".modal-add-btn"),
        idInput = document.querySelector("input[type=hidden]"),
        modelTitle = document.querySelector('.modal-title')

    addBtn.addEventListener('click', function () {
        modelForm.action = '${pageContext.request.contextPath}/student/add'
        submitBtn.textContent = '添加'
        modelTitle.textContent = '添加'
        idInput.value = null
    })

    editButtons.forEach(function(button) {
        button.addEventListener('click', function (event) {
            event.preventDefault();

            idInput.value = button.dataset.id

            modelForm.action = '${pageContext.request.contextPath}/student/update'
            submitBtn.textContent = '修改'
            modelTitle.textContent = '修改'

            fetch("${pageContext.request.contextPath}" + "/student/getById?id=" + button.dataset.id, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
            }).then(response => {
                if (!response.ok) {
                    throw new Error("HTTP error! status: " + response.status)
                }
                return response.json()
            }).then(record => {
                for (var key in record) {
                    if (key === 'id') {
                        continue
                    }
                    const input = document.querySelector('input[name="' + key + '"]')
                    input.value = record[key]
                }
            }).catch(error => {
                console.error('Fetch error:', error)
            })
        })
    });

</script>
</html>
