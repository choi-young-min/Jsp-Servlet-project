<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>U B A</title>
    <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Kalam&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Righteous&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Anton&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Cinzel&display=swap" rel="stylesheet">
    <link href="css/home.css" rel="stylesheet">

</head>
<body>
       <div id="login">
       <form name="loginfrm" method="post">
         <input id="id_login" name="loginid" placeholder="아이디를 입력하세요" required>
         <input id="pwd_login" name="loginpwd" type="password" placeholder="비밀번호" required>
         <br>
         <input type="button" class="btn1" value="로그인" id="go_login">
         <input type="button" class="btn1" value="취소" id="cancle_login">
         <input type="button" class="btn1" value="회원가입" id="go_join">
        </form>
      </div>
      
      <div id="join">
        <form name="joinfrm">
	        <input id="id" name="id" placeholder="아이디를 입력하세요" required>
	        <input type="hidden" name="reid">
	        <input id="idcheck" type="button" value="중복확인" required><br>
	        <input id="pwd" name="pwd" type="password" placeholder="비밀번호(8자이하 숫자,문자 혼합)" required><br>
	        <input id="pwdcheck" name="pwdcheck" type="password" placeholder="비밀번호 재확인" required><br>
	        <input id="name" name="name" type="text" placeholder="이름을 입력하세요" required><br>
	        <input id="email" name="email" type="email" placeholder="이메일을 입력하세요" required><br>
	        <input class="btn2" type="button" value="회원가입" id="join_us">
	        <input class="btn2" type="button" value="취소" id="cancel_join">
        </form>
    </div>
    <div id="side_bar">
        <p id="s_text"></p>
       
        <c:if test="${dto.id != null}">
	        <div style="display:none" id="board_link">
	        	<button>Board Link</button>
	        </div>
        </c:if>
    </div>
      
    <div id="wrap">
       <div class="btn">
       
           <input type="button" id="btn2" value="BASEBALL">
           <input type="button" id="btn3" value="BASKETBALL">
           <input type="button" id="btn4" value="SOCCER">
           <c:choose>
	           <c:when test="${empty dto.id}">
	           <input type="button" id="btn5" value="LOGIN">
	           </c:when>
	           <c:otherwise>
	           	<input type="button" id="btn6" value= "Welcome ${dto.id}">
	           	<input type="button" value="LOGOUT" id="logout">
	           </c:otherwise>
           </c:choose>
       </div>
       <div id="getMember">
       	<p>아이디    : ${dto.id}</p>
       	<p>비밀번호    : ${dto.pwd}</p>
       	<p>이름  : ${dto.name}</p>
       	<p>이메일 : ${dto.email}</p>
       </div>
       
       <div class="logo"><img src="UBAlogo.png"></div>
       
       
        <div id="content">
            <div>
                <video autoplay muted loop class="video" id="v1">
                    <source src="main.mp4" type="video/mp4">
                </video>
            </div>
            <div>
                <video muted loop class="video" id="v2">
                    <source src="baseball.mp4"
                    type="video/mp4">
                </video>
            </div>
            <div>
                  <video muted loop class="video" id="v3">
                    <source src="basketball.mp4" type="video/mp4">
                </video>
            </div>
            <div>
                <video muted loop class="video" id="v4">
                    <source src="football.mp4"
                    type="video/mp4">
                </video>
            </div>
        </div>
    </div>
    
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="js/home.js"></script>
    
</body>
</html>