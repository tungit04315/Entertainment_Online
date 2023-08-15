<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Phim Hay Lucas TV</title>
<link rel="icon" type="image/x-icon" href="img/iconLogo.png">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/VideoLike.css">
<link rel="stylesheet" href="css/SlideAuto.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
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
			<h3 class="title_video_like">
				<i class="fa-solid fa-circle-play"></i> Video đã thích
			</h3>
			<div class="row row_video_like"> 
				<c:forEach var="item" items="${favorites}">
				<div class="col-sm-4">
						<div class="card card_video_like">
							<div class="card-header">
								<img width="100%" height="217px"
									style="background-image: cover;" src="${item.video.poster}"></img>
							</div>
							<div class="card-body">
								<h5 class="card-title">${item.video.title}</h5>
								<p class="card-text">${item.video.descriptions}</p>
								
								<a href="./UnlikeServlet?action=unlike&id=${item.video.id}" class="btn btn-primary">UnLike</a> <a href="#"
									class="btn btn-primary" data-toggle="modal"
									data-target="#exampleModalCenter">Share</a>
								
							</div>
						</div>
				</div>
				</c:forEach>
			</div>
			<div class="modal fade" id="exampleModalCenter" tabindex="-1"
				role="dialog">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">Chia Sẻ</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form>
								<div class="form-group">
									<label for="recipient-name" class="col-form-label">Email
										bạn của bạn:</label> <input type="email" class="form-control"
										id="recipient-name">
								</div>

							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary">Chia Sẻ</button>
						</div>
					</div>
				</div>
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