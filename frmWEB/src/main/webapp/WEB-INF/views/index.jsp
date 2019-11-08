<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<c:if test="${ loginSession == null }">
		<form action="login.dcu" method="post">
			ID : <input type="text" name="id" />		
			<br/>
			PWD : <input type="text" name="pwd" />
			<br/>
			<input type="submit" value="LOGIN">
		</form>
	</c:if>
	<c:if test="${ loginSession != null }">
		${ loginSession.name } 님 로그완료!!
		&nbsp;&nbsp;&nbsp;
		<a href="logout.dcu">로그아웃</a>
	</c:if>
	
	<hr/>
	<button id="ajaxBtn">비동기 통신</button>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#ajaxBtn").click(function() {
				alert("^^");
				$.ajax({
					url  : "ajax.dcu",
					type : "post" , 
					dataType : "json" , 
					success : function(obj) {
						alert(obj.id);
						alert(obj.pwd);
					}
				});
			});
		})
	</script>
</html>










