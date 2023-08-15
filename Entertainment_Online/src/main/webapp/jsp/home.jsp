<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
</head>
<body>
	<div class="container_film">
		<div class="col-sm-12">
			<div class="row">
				<div class="col-sm-12">
					<button type="button" class="btn btn-dark">Tất Cả</button>
					<button type="button" class="btn btn-primary">Hoạt Hình</button>
					<button type="button" class="btn btn-secondary">Âm Nhạc</button>
					<button type="button" class="btn btn-success">Hài Tính
						Huống</button>
					<button type="button" class="btn btn-danger">Tin Tức</button>
					<button type="button" class="btn btn-warning">Anime</button>
					<button type="button" class="btn btn-info">Đã Xem</button>
					<button type="button" class="btn btn-light">Đề Xuất Mới</button>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="title_film" style="margin-top: 10px;">
				<h1 class="text-warning">
					<i class="fa-solid fa-grip-lines-vertical"></i> Tất Cả
				</h1>
			</div>
			<div class="row">
				<c:forEach var="item" items="${list}">
					<div class="col-sm-4">
						<div class="card" style="margin: 20px 0 20px 0;">
							<div class="card-header">
								<a href="./VideoDetail?action=watch&id=${item.href}"> <img
									width="100%" height="217px" style="background-image: cover;"
									src="${item.poster}"></img>
								</a>
							</div>
							<div class="card-body">
								<h5 class="card-title">${item.title}</h5>
								<p class="card-text">${item.descriptions}</p>
								<a href="./VideoDetail?action=like&id=${item.href}" class="btn btn-primary">Like</a> <a href="#"
									class="btn btn-primary">Share</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="col-sm-12">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">...</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
		<div class="col-sm-12">
			<div class="slider_auto">
				<div class="slide-track">
					<div class="slide">
						<div class="img"></div>
						<div class="img"></div>
						<div class="img"></div>
						<div class="img"></div>
						<div class="img"></div>
						<div class="img"></div>
						<div class="img"></div>
						<div class="img"></div>
						<div class="img"></div>
						<div class="img"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>