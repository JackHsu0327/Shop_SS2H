<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="service.impl.GoodsServiceImpl"%>
    <%
    GoodsServiceImpl msi = new GoodsServiceImpl();
    request.setAttribute("g", msi);
    %>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品更新</title>
</head>
<body>
<h1>更新商品</h1>
<form action="UpdateController" method="post" theme="simple">
        <table width=400 align="center">
			<tr>
				<td>
       		 商品編號:<input type="text" name="id" size=5>
        	 價格:<input type="text" name="price" size=5>
        	 庫存數量:<input type="text" name="quantity" size=5>   
         	<input type="submit" value="更新商品">
         </table>       
</form>
    
    <table width=500 align=center border=1>
	<tr>
		<td>商品ID<td>商品名稱<td>商品價格<td>商品數量
		${g.selectAll()} 
		<tr>
			<td colspan=4 align=center>
			<a href="index.jsp">返回首頁</a>
</table>
    
 <s:if test="hasActionMessages()">
    <p style="color:green;">
        <s:actionmessage />
    </p>
</s:if>
<s:if test="hasActionErrors()">
    <p style="color:red;">
        <s:actionerror />
    </p>
</s:if>
</body>
</html>