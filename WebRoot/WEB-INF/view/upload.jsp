<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>文件上传页面</p>
普通上传
<form action="/javaweb/upload/uploadByStream" enctype="multipart/form-data" method="post">
	<input id="files1" type="file" name="files1" multiple>
	<button type="submit">上传</button>
</form>
<hr>
利用spring解析器上传
<form action="/javaweb/upload/uploadByMultipartFile" enctype="multipart/form-data" method="post">
	<input id="files2" type="file" name="files2" multiple>
	<button type="submit">上传</button>
</form>
</body>
</html>