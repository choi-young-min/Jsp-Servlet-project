$(function(){
    var side_text = "For me, winning isn't something that happens suddenly on the field when the whistle blows and the crowds roar. - Emmitt Smith";
    $("#s_text").text(side_text);
     $(".logo").click(function(){
        $("#content").animate({
        marginLeft:"0%"
        },500);
        side_text = "Pain is just temporary thing, it may last for a minute, or an hour or a day, even a year. But eventually, it will subside. If you quit however, it will last forever - Eric Thomas";
        $("#s_text").text(side_text);
        $("#v1").get(0).play();
        $("#v2").get(0).pause();
        $("#v3").get(0).pause();
        $("#v4").get(0).pause();
        //1번
        $("#board_link").css("display","none");
    });
    $("#btn2").click(function(){
        $("#content").animate({
            marginLeft:"-100%"
        },500);
        side_text = "Show me your friends, I will show your future. You know why your life is so messed up? See out of the bums you hung around - Dan Pena";
        $("#s_text").text(side_text);
        link = "./BoardList.go?kind=1";
        $("#v2").get(0).play();
        $("#v1").get(0).pause();
        $("#v3").get(0).pause();
        $("#v4").get(0).pause();
      //3번
        $("#board_link").css("display","block");
    });
    $("#btn3").click(function(){
        $("#content").animate({
            marginLeft:"-200%"
        },500);
        side_text = "You can pretend you care seriously, but you never ever gonna pretend you are seriously there - Josh emmitt";
        $("#s_text").text(side_text);
        link = "./BoardList.go?kind=2";
        $("#v3").get(0).play();
        $("#v1").get(0).pause();
        $("#v2").get(0).pause();
        $("#v4").get(0).pause();
      //3번
        $("#board_link").css("display","block")
    });
    $("#btn4").click(function(){
        $("#content").animate({
            marginLeft:"-300%"
        },500);
        side_text = "All men are created equal, some work damn hard in pre-season - Emmitt Smith";
        $("#s_text").text(side_text);
        link = "./BoardList.go?kind=3"
        $("#v4").get(0).play();
        $("#v1").get(0).pause();
        $("#v2").get(0).pause();
        $("#v3").get(0).pause();
      //3번
        $("#board_link").css("display","block")
    });
    $("#btn5").click(function(){
        $("#login").slideToggle(500);
        $("#login").focus();
    });
    $("#go_join").click(function(){
    	
        $("#join").slideToggle(500); 
        $("#join").focus();
    });
    $("#cancle_login").click(function(){
        $("#login").slideUp(500); 
    });
    $("#cancel_join").click(function(){
        $("#join").slideUp(500);
        $("#id_login").text("");
        $("pwd_login").text("");
    });
    $("#join").keyup(function(e){
    	if(e.keyCode == 13){
    		$("#join_us").click();
    	}
    });
    $("#join_us").click(function(){
    	var id = document.joinfrm.id.value;
    	var reid = document.joinfrm.reid.value;
    	var pwd = document.joinfrm.pwd.value;
    	var pwdcheck = document.joinfrm.pwdcheck.value;
    	var name = document.joinfrm.name.value;
    	var email = document.joinfrm.email.value;
    	
    	if(id==""){
    		alert("아이디를 입력해주세요.");
    		id.focus();
    	}else if (id != reid) {
    		alert("Click 'Check ID' Button");
    		id.focus();
    	}else if(pwd==""){
    		alert("비밀번호를 입력해주세요.");
    		pwd.focus();
    	}else if(pwdcheck==""){
    		alert("비밀번호 확인을 입력해주세요.");
    		pwdcheck.focus();
    	}else if(pwd!=pwdcheck){
    		alert("비밀번호가 일치하지 않습니다.");
    		pwd = "";
    		pwdcheck = "";
    		pwd.focus();
    	}else if(name==""){
    		alert("이름을 입력해주세요.");
    		name.focus();
    	}else if(email==""){
    		alert("이메일를 입력해주세요.");
    		email.focus();
    	} else{
            document.joinfrm.action = "./MemberJoin.go";
            document.joinfrm.submit();
            alert("회원가입 성공!!");
    	}
    });
    $("#board_link button").click(function(){
        location.href=link;
    });
    $("#hide").click(function(){
        $("#side_bar").hide();
    });
    $("#board_link button").mouseover(function(){
        $(this).css("color","yellow");
    });
    $("#board_link button").mouseleave(function(){
        $(this).css("color","white");
    });
    $("#go_login").click(function(){
    	document.loginfrm.action = "./Login.go";
    	document.loginfrm.submit();
    	$("#login").focus();
    });
    $("#login").keyup(function(e){
    	if(e.keyCode == 13){
    		document.loginfrm.action = "./Login.go";
    		document.loginfrm.submit();
    	}
    });
    $("#logout").click(function(){
    	location.href = "./Logout.go";
    	
    });
    //아이디 중복 확인
    $("#idcheck").click(function(){
    	var id = document.joinfrm.id.value;
    	var url = "./idCheck.go?id="+id;
    	if (id == "") {
    		id.focus();
    		return;
    	}
    	window.open(url, 
				"_blank_1",
				"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=120"); 
    });
    $("#btn6").click(function(){
    	$("#getMember").slideToggle(500); 
    });
});
