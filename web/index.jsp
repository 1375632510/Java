<%--
  Created by IntelliJ IDEA.
  User: chenyu
  Date: 2020/5/15
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx",ctx);
%>
<html>
  <head>
    <title>首页</title>

      <style>
          a{
                text-decoration: none;
              color: black;
          }
          h3{
              width: 180px;
              height: 38px;
              margin: 100px auto;
              text-align: center;
              line-height: 38px;
              background: deepskyblue;
              border-radius: 5px;
          }
      </style>
  </head>
  <body>
  <h3>
      <a href="${ctx}/book/allBook">进入书籍页面</a>
  </h3>
  </body>
</html>
