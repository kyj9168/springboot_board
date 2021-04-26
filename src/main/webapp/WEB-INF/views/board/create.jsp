<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Board Create</title>
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
		<h2>Create Board form</h2>
		<form action="/board/create" method="post">
			<div class="form-group">
				<label for="form">Writer:</label> <input type="text"
					class="form-control" id="writer" placeholder="Enter Writer"
					name="b_writer">
			</div>
			<div class="form-group">
				<label for="form">Title:</label> <input type="text"
					class="form-control" id="title" placeholder="Enter Title"
					name="b_title">
			</div>
			<div class="form-group">
				<label for="form">contents:</label>
				<textarea rows="20" cols="100" id="contents"
					placeholder="Enter contents" name="b_contents"></textarea>
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
			<a href="/board"><button type="button" class="btn btn-info">Move to List</button></a>
	</div>
</body>
</html>