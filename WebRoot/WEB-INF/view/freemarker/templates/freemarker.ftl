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
</body>
</html>