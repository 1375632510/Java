<%--
  Created by IntelliJ IDEA.
  User: chenyu
  Date: 2020/5/16
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 cloumn">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>

    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <!-- id没有传入 -->
        <!-- id传入隐藏域 -->
        <input type="hidden" name="bookID" value="${book.bookID}">
        书籍名称：<input type="text" name="bookName" value="${book.bookName}" required><br><br><br>
        书籍数量：<input type="text" name="bookCounts" value="${book.bookCounts}" required><br><br><br>
        书籍详情：<input type="text" name="detail" value="${book.detail}" required><br><br><br>
        <input type="submit" value="修改">
    </form>

</div>

</body>
</html>
