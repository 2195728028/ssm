
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/asserts/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/asserts/css/dashboard.css"  rel="stylesheet">

<form  method="post" action="${pageContext.request.contextPath}/perm">
    <div class="form-group">
        <label>姓名</label>
        <input name="user.username" type="text" class="form-control" placeholder="zhangsan" >
    </div>
    <div class="form-group">
        <label>角色</label><br/>
        <select class="form-control" name="role.id">
            <c:forEach items="${roles}" var="role">
                <option value="${role.id}">${role.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>权限</label>
        <select class="form-control" name="perm">
            <c:forEach items="${menus}" var="menu">
                <option value="${menu.perm}">${menu.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary" >添加</button>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/jquery-3.2.1.slim.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/popper.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/bootstrap.min.js"></script>
