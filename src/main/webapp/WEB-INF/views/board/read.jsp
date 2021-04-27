<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Read</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>No : ${board.b_id}</h2>
		<div class="form-group">
			<label for="form">작성자: ${board.b_writer}</label>
		</div>
		<div class="form-group">
			<label for="form">제목: ${board.b_title}</label>
		</div>
		<div class="form-group">
			<label for="form">내용:</label>
			<textarea rows="20" cols="100" id="contents" readonly="readonly">${board.b_contents}</textarea>
		</div>
		<div class="form-group">
			<label class="form">작성일 : ${board.b_created_date} </label>
			<label class="form">수정일 : ${board.b_update_date} </label>
		</div>
		<div>
		<a href="/board"><button type="button" class="btn btn-info">게시판 목록</button></a>
		<a href="/board/update/${board.b_id}"><button type="button" class="btn btn-success">수정</button></a>
		<button type="button" id="deleteBoard" class="btn btn-danger">삭제</button>
		</div>
	</div>
</body>
<script type="text/javascript">
$("#deleteBoard").click(function(){
	var result = confirm("정말 삭제하시겠습니까?");
	if(result){
		location.href = '/board/delete/${board.b_id}';
	}
});
</script>
</html>