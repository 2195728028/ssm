<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/asserts/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/asserts/css/dashboard.css" rel="stylesheet">
<!DOCTYPE html>
<!-- saved from url=(0052)http://getbootstrap.com/docs/4.0/examples/dashboard/ -->
<html lang="en">



            <h2><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/perm/permAdd" >权限添加</a></h2>

            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>流水号号</th>
                        <th>编号</th>
                        <th>用户名</th>
                        <th>角色</th>
                        <th>权限名称</th>
                        <th>权限代码</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${menus}" var="menu" varStatus="vs">
                    <tr>
                        <td>${vs.count}</td>
                        <td>${menu.id}</td>
                        <td>${menu.user.username}</td>
                        <td>${menu.role.name}</td>
                        <td>${menu.name}</td>
                        <td>${menu.perm}</td>
                        <td>

                            <%--<a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/emp/${emp.id}">编辑</a>--%>


                            <button class="btn btn-sm btn-danger" onclick="del(${menu.id})">删除</button>

                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <form action="${pageContext.request.contextPath}/perm" method="post" id="f1">
                    <input type="hidden" name="id" id="id">
                    <input type="hidden" name="_method" value="delete" >

                </form>
            </div>
            <script type="text/javascript">
                function del(id){
                    if(confirm("是否确定要删除?")){
                        //发送请求
                          var elementById = document.getElementById("id");
                        elementById.value = id;

                        document.getElementById("f1").submit();

                    }

                }

            </script>


