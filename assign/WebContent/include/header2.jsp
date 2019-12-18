<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	HttpSession ses = request.getSession();
	String id =	(String)ses.getAttribute("id");
	request.setAttribute("id", id);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>BoardWrite</title>
    
 	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.js"></script>
	
	<link href="../css/board.css" rel="stylesheet">
  
    
    
    <script>
            var y = 0;
        $(document).ready(function(){
            
            $(window).scroll(function(){
                /* $("p").text($(window).scrollTop()); */
                 y = $(window).scrollTop();
                if(y>220){
                    $("#head_logo").hide();
                    $("#menu").addClass("fixed");
                    
                }else if(y<220){
                    $("#head_logo").show();
                    $("#menu").removeClass("fixed")
                }
            });
            $("#btn_menu1").click(function(){
                location.href="../BoardList.go?kind=1";
            });
            $("#btn_menu2").click(function(){
                location.href="../BoardList.go?kind=2";
            });
            $("#btn_menu3").click(function(){
                location.href="../BoardList.go?kind=3";
            });
            $("#menu_logout").click(function(){
                location.href="../Logout.go";
            });
            $("#head_logo img").click(function(){
            	location.href="./home.jsp";
            	
            });
            
        });
    </script>

    
</head>
<body>
    <div id="headline">
        <div id="head_logo">
            <img src="UBAlogo.png">
        </div>
        <div id="menu">
            <ul>
            <li id="blank1"></li>
                <li id="btn_menu1">Base Ball</li>
                <li id="btn_menu2">Basket Ball</li>
                <li id="btn_menu3">Soccer</li>
                <li id="menu_logout">LogOut</li>
              <li id="blank2"></li>
            </ul>
        </div>
    </div>