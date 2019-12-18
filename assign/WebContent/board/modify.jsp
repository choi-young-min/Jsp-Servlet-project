<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<%@ include file="../include/header.jsp" %>
<div class="row">
	<div class="col-lg-12" style="margin-top: 30px;margin-bottom: 30px;">
		<h1 class="page-header"></h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div id="get_border" style="display:block">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading"></div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<form action=""  method="post" name="frm" class="frm-class">
						<div class="form-top">
							<div class="form-group" ><!-- style=";" -->
								<label class="b-font">BNO</label><input class="form-control" name="bno" value='<c:out value="${bno.bno }" />'  readonly="readonly">
							</div>
							<div class="form-group"><!-- margin-left: 34%; -->
								<label class="b-font">Writer</label><input class="form-control" name="writer" value='<c:out value="${bno.w_id }"/>'  readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="b-font">Title</label><input class="form-control"  id="title" name="title" value='<c:out value="${bno.title }" />'  readonly="readonly">
						</div>
						<div class="form-group">
							<label class="b-font">Text area</label>
							<textarea class="form-control" rows="20" name="content"  id="content" style="height:500px;overflow:scroll;">${bno.content }</textarea>
						</div>
						<div class="reply-title">REPLY</div>
						<hr style="background-color: gray;">
						<div id="reply-section">
							<c:forEach var="list" items="${list }">
								${list.w_id } : ${list.content }<br>
							</c:forEach>
						</div>
							
							<c:forEach var="item" items="${reply}">
								<a href="get.go?replyNum=${item}&bno=${bno.bno}">[${item}]</a>
							</c:forEach>
							<div>
								<div class="reply-id">아이디 : ${id }</div>
								<textarea class="textarea" rows="5px" cols="1000px" name="reply-content"></textarea>
						</div>
						<c:if test="${bno.w_id eq id or id eq 'admin'}">
							<input type="button"  data-oper='modify' class="btn btn-default" id="update" value="Modify" style="background-color: #36b9cc; color: white;">
							<button data-oper='modify' class="btn btn-default" id="delete" style="background-color: #36b9cc; color: white;">delete</button>
						</c:if>
						<br>
						<br>
						<div class="line-1">
							<button data-oper='list' class="btn btn-info" id="list">List</button>
							<button class="btn btn-info" id="insert-reply">reply</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>
	  <!-- Bootstrap core JavaScript-->
	  <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	  <!-- Page level plugins -->
	  <script src="./resources/vendor/datatables/jquery.dataTables.min.js"></script>
	  <script src="./resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
	
	  <!-- Page level custom scripts -->
	  <script src="./resources/js/demo/datatables-demo.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
    	<%-- $(document).ready(function(){
    		<%
			//String id = (String)request.getAttribute("id");
			System.out.print(id +" : 아이디입니다.");
			if(id!= null){ 
		%>
		<% }else{ %>
			
			location.href = "./index.go";
			alert("잘못된 접근 방법입니다.");
		<%}%>
    	}); --%>
    	$(function(){
    		var isModify = 0;
    		$("#insert-reply").click(function(){
    			document.frm.action = '/assignment/replyinsert.go';
    			document.frm.submit();
    		});
    		$("#delete").click(function(){
    			document.frm.action = '/assignment/deleteboard.go';
    			document.frm.submit();
    		});
    		$("#update").click(function(){
    			$("#content").focus();
                if(isModify == 0){
                 $("#content").removeAttr("readonly");
                 $("#title").removeAttr("readonly");
                    isModify = 1;
                }else{
                    $("#content").attr("readonly",true);
                    $("#title").attr("readonly",true);
                    isModify = 0;
                    document.frm.action = '/assignment/UpdateBoard.go';
        			document.frm.submit();
                }
            });
    		$("#list").click(function(){
    			document.frm.action = '/assignment/BoardList.go?kind='+${kind};
    			document.frm.submit();
    		});
    	});
    </script>