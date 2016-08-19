<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	author : ${author}
	<table>
		<tr>
			<td>${people.name}</td>
			<td>${people.sex}</td>
			<td>${people.age}</td>
		</tr>
	</table>
	<#assign x="zouyang">
	角色：${fmkMethodTest(x)}
	<#assign y="admin">
	角色：${fmkMethodTest(y)}
	<br><br>
	
	<@upper name="zouyang" name2="admin">
		<#list ["abc","dDv","JDK"] as args>
			${args}
		</#list>
	</@upper>
	<br><br>
	
	<@repeat count=3>
		<span>循环测试<span><br>
	</@repeat>
	<br>
	
	<@repeat count=3; rank,rank2>
	  ${rank}. Test
	  ${rank2}<br>
	</@repeat>
	<br><br>
	${peo.name}
</body>
</html>