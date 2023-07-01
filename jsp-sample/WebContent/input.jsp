<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Hello JSP</title>
	</head>
	<body>
			<P>渡してみた値</P>
			<%
			out.print(request.getAttribute("str"));
			out.print("<br>");
			out.print((HashMap<String, Object>) request.getAttribute("strMap"));
			out.print("<br>");
			%>
		<br>
		
		<!-- POSTで処理するサーブレットを分割してみる -->	
		<form method="post">
			<div class="example">
				<label for="namelabel">名前</label>
				<input type="text" name="name" id="namelabel" placeholder="例）鈴木　太郎">
			</div>
			<div class="example">
				<label for="maillabel">メールアドレス</label>
				<input class="inputs" type="email" name="email" id="maillabel" placeholder="○○○.jp">
			</div>
			<div class="example">
				<label for="opinionlabel">ご意見</label>
				<textarea name="opinion" id="opinionlabel"></textarea>
			</div>
			<div class="example">
			<input type="submit" value="送信する">
			</div>  
		</form>
		
		<br>
		
		<P>formに入力した内容</P>
		<%
		String noneMessage = "未入力";
		String name = (String)request.getAttribute("nameForOutput");
		String email = (String)request.getAttribute("emailForOutput");
		String opinion = (String)request.getAttribute("opinionForOutput");
		if(name == "" || email == "" || opinion == ""){
			out.println("<p>名前：　" + (name != "" ? name : noneMessage) + "</p>");
			out.println("<p>メールアドレス：　" + (email != "" ? email : noneMessage) + "</p>");
			out.println("<p>意見：　" + (opinion != "" ? opinion : noneMessage) + "</p>");
		}
		%>
	</body>
</html>