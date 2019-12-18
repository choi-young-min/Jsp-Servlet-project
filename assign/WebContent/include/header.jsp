<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="description" content="">
	  <meta name="author" content="">
    <title>Board</title>
    <!-- Custom fonts for this template -->
  <link href="./resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="./resources/css/sb-admin-2.min.css" rel="stylesheet">
	<link href="./css/board.css" rel="stylesheet">
  <!-- Custom styles for this page -->
  <link href="./resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
                location.href="./BoardList.go?kind=1";
            });
            $("#btn_menu2").click(function(){
                location.href="./BoardList.go?kind=2";
            });
            $("#btn_menu3").click(function(){
                location.href="./BoardList.go?kind=3";
            });
            $("#menu_logout").click(function(){
                location.href="./Logout.go";
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
                <li id="btn_menu1">BASEBALL</li>
                <li id="btn_menu2">BASKETBALL</li>
                <li id="btn_menu3">SOCCER</li>
                <li id="menu_logout">LogOut</li>
              <li id="blank2"></li>
            </ul>
        </div>
    </div>