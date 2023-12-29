<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- ajax를 사용하려면 jquery "원본" 필요, "slim" 불가 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
		<div class="container">
		<h1>회원가입</h1>
		<form method="post" action="/lesson06/ex01/add-user">
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="form-control col-3">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예) 19990309">
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="email" name="email" class="form-control col-3">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea for="introduce" id="introduce" name="introduce" class="form-control"></textarea>
			</div>
			<%-- AJAX 로 할때는 submit 이 되면 안되기에 button으로 변경 --%>
			<button id="joinBtn" type="button" class="btn btn-success">회원가입</button>
		</form>
	</div>
	
	<script>
		$(document).ready(function() {
			// jquery 의 submit 기능 이용하기
			/*
			$("form").on('submit', function(e) {
				//e.preventDefault(); // 서브밋 기능 중단
				//alert("서브밋");
				
				// validation
				let	name = $("#name").val();
				if (name.length < 1) {
					alert("이름을 입력하세요");
					return false; // 서브밋 안함.
				}
				
				let yyyymmdd = $("#yyyymmdd").val();
				if (yyyymmdd == "") {
					alert("생년월일을 입력하세요");
					return false; // submit 안함
				}
				let email = $("#email").val();
				if (!email) {
					alert("이메일을 입력하세요");
					return false;
				}
				
				// 여기까지 도달하면 submit(화면 이동)
			});
			*/
			
			// 2) jquery 의 AJAX 통신 이용하기
			$("#joinBtn").on('click', function() {
				//alert("asd");
				let	name = $("#name").val();
				if (name.length < 1) {
					alert("이름을 입력하세요");
					return; 
				}
				
				let yyyymmdd = $("#yyyymmdd").val();
				if (yyyymmdd == "") {
					alert("생년월일을 입력하세요");
					return;
				}
				
				let email = $("#email").val();
				if (!email) {
					alert("이메일을 입력하세요");
					return;
				}
				
				let introduce = $("#introduce").val();
				
				console.log(name);
				console.log(yyyymmdd);
				console.log(email);
				console.log(introduce);
				
				// AJAX : 비동기로 서버에 요청
				$.ajax({
					// request
					type: "post"
					, url: "/lesson06/ex01/add-user"
					, data: {"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}
					
					// response
					, success:function(data) { // call back 함수
						// dara param : 응답값
						alert(data); //"성공"
						if (data == "성공") {
							location.href = "/lesson06/ex01/after-add-user-view"; // GET 요청 (화면이동)	
						}
					} ,
					error:function(request, status, error) {
						alert(request);
						alert(status);
						alert(error);
					} ,
					complete:function(data) {
						// 앞으로 사용하지않음.
						alert("성공이든 실패든 완료");
					}
				});
			});
		});
	</script>
</body>
</html>