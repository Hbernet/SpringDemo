<%--
  Created by IntelliJ IDEA.
  User: hb
  Date: 2020/8/11
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>二东易买</title>
</head>
<body>
欢迎来到二东易买
<%=request.getRemoteUser()%>
<br><a href="http://192.168.188.133:8080/cas/logout?service=http://www.baidu.com">退出登录</a>
</body>
</html>

