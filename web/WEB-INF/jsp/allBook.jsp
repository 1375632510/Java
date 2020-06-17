<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenyu
  Date: 2020/5/16
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx",ctx);
%>
<html>
<head>
    <title>书籍展示</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 cloumn">
            <div class="page-header">
                <h1>
                    <small>书籍列表---显示所有书籍</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <%-- toAddBook--%>
                <a href="${ctx}/book/toAddBook" class="btn btn-primary">新增书籍</a>
                    <a href="${ctx}/book/allBook" class="btn btn-primary">显示全部书籍</a>
            </div>
            <div class="col-md-4 column">
                <form action="${ctx}/book/queryBook" method="post" style="float: right">
                    <span style="color: red;font-weight: bold">${error}</span>
                    <input type="text" name="queryBookName" placeholder="请输入要查询的书籍名称">
                    <input type="submit" value="查询" class="btn btn-primary">
                </form>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <th>书籍序号</th>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </thead>
                <tbody>

                    <%-- 书籍从数据库中查询出来 --%>
                    <c:forEach var="book" items="${list}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${ctx}/book/toUpdate?id=${book.bookID}">修改</a>
                                &nbsp; |&nbsp;
                                <a href="${ctx}/book/deleteBook/${book.bookID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
