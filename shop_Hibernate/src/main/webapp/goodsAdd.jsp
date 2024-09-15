<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品新增</title>
</head>
<body>
<h1>新增商品</h1>
<form action="AddController" method="post">
		<table width=400 align="center">
		<tr>
			<td>
			商品名稱:<input type="text" name="name"><br>
			價格:<input type="text" name="price"><br>
			庫存數量:<input type="text" name="quantity"><br>
			<input type="submit" value="新增商品">
		</table>	

</form>

<s:if test="hasActionErrors()">
    <div style="color: red;">
        <s:actionerror />
    </div>
</s:if>

<<s:if test="hasActionMessages()">
    <div style="color: green;">
        <s:actionmessage />
    </div>
</s:if>

<a href="index.jsp">返回首頁</a>

</body>
</html>