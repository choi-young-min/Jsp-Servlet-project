<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<html>
		<head>
		<meta charset="UTF-8">
		<title>아이디 중복 체크</title>
	</head>
	<body>
	<script>
		<c:if test="${result==1}">
			alert("아이디가 중복입니다.");
			opener.joinfrm.id.value="";
			self.close(); 
		</c:if>
		<c:if test="${result==0}">
			alert("사용가능한 아이디 입니다.");
			opener.joinfrm.id.value="${id}";
			opener.joinfrm.reid.value="${id}";
			self.close();
		</c:if>
		</script>
	</body>
</html>