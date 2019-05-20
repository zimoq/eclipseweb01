<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
		function f1(){ 
			$.ajax({
					url:"aaa.action",
					type:"post",
					data:'{"name":"username","password":"4"}',
					contentType:"application/json;charset=utf-8",
					dataType:"json",
					success:function(data){
						alert(data);
					}
			});
		}
		
	</script>
</head>
<body>
	<input type="button" onclick="f1()" value="提交" />
</body>
</html>