<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" charset="UTF-8" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="../js/webuploader.js"></script>
</head>
<body>
<p>文件上传页面</p>
普通上传<br>
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
<hr>
利用webuploader插件
多文件上传
 <div class="btns">
     <div id="picker">上传文件</div>
     <span id="filesNum"></span><br>
     <span id="percent">当前进度</span><br>
     <button id="ctlBtn" class="btn btn-default" onclick="beginUpload()">开始上传</button><br>
     <button id="ctlBtn" class="btn btn-default" onclick="stopUpload()">暂停上传</button><br>
    <button id="ctlBtn" class="btn btn-default" onclick="retryUpload()">继续上传</button>
 </div>
<script>
	var uploader;
	$(document).ready(function(){
		var url = "/javaweb/upload/uploadByStream";
		uploader = new WebUploader.Uploader({
			 pick:{
				 id:'#picker',
				 multiple:true
			 },
			 server: url,
			 method:'POST'
		});
		uploader.on("filesQueued",function(){
			var files = uploader.getFiles();
			$("#filesNum").text("已选择文件数 ："+files.length);
			percent = 0;
		});
		uploader.on("startUpload",function(){
			alert("文件现在开始上传");
		});
		uploader.on("uploadProgress",function(file,percentage){
			var percent = (percentage * 100)/1 + '%';
			$("#percent").text("当前进度："+percent);
		});
		uploader.on("uploadFinished",function(){
			alert("文件上传结束");
			upload.reset();
		});
		uploader.on("uploadError",function(){
			alert("上传文件出错");
		});
	});
	
	var beginUpload = function(){
		uploader.upload();
	}	
	var stopUpload = function(){
		uploader.stop();
	}
	var retryUpload = function(){
		uploader.retry();
	}

</script>
</body>
</html>