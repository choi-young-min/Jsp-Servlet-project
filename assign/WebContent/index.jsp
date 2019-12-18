<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
        <!-- Begin Page Content -->
        <div class="container-fluid" style="height: 100vh;">

          <!-- Page Heading -->
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3"  style= "background-color: #3c3d3e;" >
              <h6 class="m-0 font-weight-bold text-primary" ><h1 class="h3 mb-2 text-gray-800">
              	<c:if test="${kind eq 1 }">
              		<span class="ball-name">BASEBALL</span>
              	</c:if>
              	<c:if test="${kind eq 2 }">
              		<span class="ball-name">BASKETBALL</span>
              	</c:if>
              	<c:if test="${kind eq 3 }">
              		<span class="ball-name">SOCCER</span>
              	</c:if>
              </h1></h6>
            </div>
            <div class="card-body" style="background-color: #3c3d3e;">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                   <thead>
                    <tr>
                      <th>#번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>수정일</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${list }" var="board">
                    <tr>
                    <c:set var="count" value="${count+1 }" />
                      <td><c:out value="${count }" /></td>
                      <td><a class="move" href='./get.go?bno=<c:out value="${board.bno }"/>'>
                      <c:out value="${board.title }"/></a></td>
                      <td><c:out value="${board.w_id }"/></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }" /></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate }" /></td>
                    </tr>
                   </c:forEach>
                  </tbody>
                  <tfoot>
                    <tr>
                      <th>#번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>수정일</th>
                    </tr>
                  </tfoot>
                </table>
                <input type="button" value="Write" id="addboard">
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

  <!-- Bootstrap core JavaScript-->
  <script src="./resources/vendor/jquery/jquery.min.js"></script>
  <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Page level plugins -->
  <script src="./resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="./resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="./resources/js/demo/datatables-demo.js"></script>
	<script>
		$(function(){
			$("#addboard").click(function(){
				location.href='board/boardWriteForm.jsp?';
			});
		});
	</script>
<%@ include file="./include/footer.jsp" %>
