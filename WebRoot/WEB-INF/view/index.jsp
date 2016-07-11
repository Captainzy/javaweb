<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${basePath}/js/jquery-1.11.3.min.js"></script>
  </head>
  
  <body>
    <button type="button" onclick="submit()">发送ajax请求</button>
    <table>
    	<tbody>
    		<tr>
    			<td>姓名</td>
    			<td id="userName">${userName }</td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td id="password">${password }</td>
    		</tr>
    	</tbody>
    </table>
    <script>
    	$(function(){
    		
    		
    	});
    	
    	function submit(){
    		alert("发送请求");
    		var url = "${basePath}/Test/getUserInfoNew?userName=ZOUYANG&password=ZOUYANG";
    		document.getElementById("userName").innerHTML = "23";
    		alert(url);
    		$.ajax({
    			url:url,
    			data:null,
    			type:"GET",
    			dataType:"json"
    			success:function(rs){
    				
    				$("#userName").innerHTML = "${userName}";
    				$("#password").innerHTML = "${password}";
    			}
    		
    		}); 
    		
    	}
    	
    </script>
  </body>
</html>
