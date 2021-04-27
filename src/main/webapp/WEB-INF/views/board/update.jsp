<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>KYJ Board</title>
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
<style>
	textarea {
		width: 100%;
	}
</style>
<body>
	<div class="container">
		<h2>Update Board form</h2>
		<form action="/board/update/${board.id}" method="post">
			<input type="hidden" value="${board.id }" name="id">

			<div class="form-group">
				<label for="form">Writer:</label> <input type="text"
					class="form-control" id="writer" name="writer"
					readonly="readonly" value="${board.writer }">
			</div>

			<div class="form-group">
				<label for="form">Title:</label> <input type="text"
					class="form-control" id="title" name="title"
					value="${board.title}">
			</div>
			<div class="form-group">
				<label for="form">contents:</label>
				<textarea rows="20" cols="100" id="contents" name="contents"
				>${board.contents}</textarea>
			</div>
			<button type="submit" class="btn btn-primary">수정</button>
		</form>
		<a href="/board/${board.id}"><button type="button" class="btn btn-danger">취소</button></a>
		<a href="/board"><button type="button" class="btn btn-info">게시판 목록</button></a>
	</div>
</body>
</html>