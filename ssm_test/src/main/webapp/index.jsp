<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<script src="js/jquery-2.2.4.min.js" ></script>
<title>首页</title>
</head>
<body>
<a href="User/outlogin">注销</a>
<style>
.left{
	width:15%;height: 500px;
}
.right{
width:85%;height: 500px;position: absolute;left: 15%;top:0;
}
</style>
<script type="text/javascript">
function ok(o){
	if(o.contentWindow.location.href.indexOf("login")>0){
		open("login.html","_self");
	}
	
}
</script>
<div class="left">
<a href="Book/index" target="right">book</a></br>
<a href="Type/index" target="right">type</a>
</div>

<div class="right">
<iframe name="right" width="300" height="300" src="Book/index" onload="ok(this);"></iframe>
</div>
</body>
</html>