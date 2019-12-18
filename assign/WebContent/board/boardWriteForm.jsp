<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header2.jsp" %>
<script>
	<%-- form의 textarea에 summernote 적용 --%>
	$(document).ready(function() {
		<%
			//String userid = request.getParameter("id");
			System.out.print(id);
			if(id!= null){
		%>
		<% }else{ %>
			
			location.href = "../index.go";
			alert("잘못된 접근 방법입니다.");
		<%}%>
		
		
		$('#content').summernote({
			height: 700,
			fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
			fontNamesIgnoreCheck : [ '맑은고딕' ],
			focus: true
		});
		$("#okay").click(function(){
			var title = document.frm.title.value;
			if(title == ""){
				alert("제목을 입력해주세요");
			}
			else{
				document.frm.action  = "../addboard.go";
				document.frm.submit();
			}
		});
	});
</script>
</head>
<body>
	<div>
		<div class="write-border">
			<div class="w3-margin-top w3-main" style="width: 95%; margin: 0 auto;">
				<form method="post" name="frm">
					<p class="w-font">Title</p>
					<div class="w3-margin-bottom w3-border">
						<input type="text" id="title1" name="title" class="w3-input w3-border w3-white" autofocus placeholder="subject">
					</div>
					<div>
						<p class="w-font">Content</p>
						<textarea name="content" id="content" rows="50" cols="50"></textarea>
					</div>
					<div align="center">
						<input type="hidden" name="id" value="${id }">
						<input type="button" value="확인" class="w3-button w3-white w3-round-small" id="okay"> &nbsp;
						<input type="button" value="취소" class="w3-button w3-white w3-round-small" onclick="history.go(-1)">
					</div>
				</form>
			</div>
		</div>
	</div>
<%@ include file="../include/footer.jsp" %>