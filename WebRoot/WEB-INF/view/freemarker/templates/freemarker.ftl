<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	author : ${author}<br><br>
	<#if author == "zouyang">
		Author's name is zouyang;
	</#if>
	<br><br>
	<#assign peoa="zhang">
	<#if peoa=="zhang">
		${peoa}
	</#if>
	<br><br>
	<#list list as item>
		name: ${item.name}<br>
		age : ${item.age}<br>
		sex : ${item.sex} <br>
	</#list>
	<br><br>
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
	
	<@repeat count=3 flag=true>
		falt
	</@repeat>
	<br><br>
	<#macro repeat2 count>
	  <#list 1..count as x>
	    <#nested x, x/2, x==count>
	  </#list>
	</#macro>
	<@repeat2 count=4 ; a, b, c,d>
	  ${a}. ${b}<#if c> Last!</#if>
	 </@repeat2>
	 
	 
</body>
</html>