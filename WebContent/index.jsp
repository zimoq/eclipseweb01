<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	 <a href="show.action?id=1">进入ok页面</a>
	 <a href="find.action">进入find页面</a><br>
	 
	 <c:if test="${errors!=null }">
	 	<c:forEach items="${errors }" var="err">
	 		${err.defaultMessage }
	 	</c:forEach>
	 </c:if>
	 
	 <form action="login.action" method="post">
	 	用户名：<input name="name" type="text"/><br>
	 	密码：<input name="password" type="password"/><br>
	 	<input type="submit" value="提交"/>
	 </form>
	 
	 <form action="up.action" method="post" enctype="multipart/form-data">
	 	上传文件<input type="file"name="user_pic"/>
	 	<input type="submit" value="提交"/>
	 </form>
</body>
</html>