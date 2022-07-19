<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Mutter,java.util.List"%>
<%
User loginUser = (User) session.getAttribute("loginUser");
List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶメイン</title>
</head>
<body>
	<h1>どこつぶメイン</h1>
	<p>${loginUser.name }さん、ログイン中〜</p>
	<p>
		<a href="/docoTsubu/logout">ログアウト</a>
	</p>
	<p>
		<a href="/docoTsubu/main">更新</a>
	</p>
	<form action="/docoTsubu/main" method="post">
		<input type="text" name="text"> <input type="submit"
			value="つぶやく">
	</form>
	<%
	for (Mutter mutter : mutterList) {
	%>
	<p><%=mutter.getUserName()%>
		:
		<%=mutter.getText()%>
	</p>

	<%
	}
	%>





	<%
	if (errorMsg != null) {
	%>
	<p><%=errorMsg%></p>
	<%
	}
	%>


</body>
</html>