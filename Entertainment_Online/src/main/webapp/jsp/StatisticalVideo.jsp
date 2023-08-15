<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Phim Hay Lucas TV</title>
<link rel="icon" type="image/x-icon" href="img/iconLogo.png">
<link rel="stylesheet" href="css/index.css">

<link rel="stylesheet" href="css/SlideAuto.css">
<link rel="stylesheet" href="css/Manage.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
</head>
<body class="body">
	<div class="container-fuild">

		<div class="container">
			<header>
				<div class="logo">
					<a href="./AdminsServlet">ADMINISTRATION TOOL</a>
				</div>
				<nav class="signin">
					<ul class="signin_item_links">
						<li><a href="./AdminsServlet">Trang Chủ</a></li>
						<li><a href="#">Videos</a></li>
						<li><a href="#">Tài Khoản Người Dùng</a></li>
						<li><a href="#">Thống Kê</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Tài Khoản </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="./ForgotPassword">Quên Mật Khẩu</a> <a
									class="dropdown-item" href="./UpdatePassword">Đổi Mật Khẩu</a> <a
									class="dropdown-item" href="./UpdateProfileServlet1">Cập Nhật Thông Tin</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="./Logout">Đăng Xuất</a>
							</div></li>
					</ul>
				</nav>
			</header>
			<nav class="nav_item_links">
				<ul>
					<li><a href="https://bom.so/4uzADd">Youtube</a></li>
					<li><a href="https://bom.so/gEoQL1">Facebook</a></li>
					<li><a href="https://www.instagram.com/lucasit041001/">Intagram</a>
					</li>
					<li><a href="http://tungle04.bio.link/">Website</a></li>
				</ul>
			</nav>



			<div class="container_film">
				<div class="title_film" style="margin-top: 10px;">
					<h3 class="text-warning">
						<i class="fa-solid fa-grip-lines-vertical"></i> Quản Lý Video
					</h3>
				</div>
				<div class="col-sm-12">
					<nav>
						<div class="nav nav-tabs" id="nav-tab" role="tablist">
							<a class="nav-item nav-link active" id="nav-home-tab"
								data-toggle="tab" href="#nav-home" role="tab"
								aria-controls="nav-home" aria-selected="true">Yêu Thích</a> <a
								class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
								href="#nav-profile" role="tab" aria-controls="nav-profile"
								aria-selected="false">Yêu Thích Theo Tiêu Đề</a> <a
								class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
								href="#nav-share" role="tab" aria-controls="nav-share"
								aria-selected="false">Video Chia Sẻ</a>
						</div>
					</nav>
					<div class="tab-content" id="nav-tabContent">
						<div class="tab-pane fade show active" id="nav-home"
							role="tabpanel" aria-labelledby="nav-home-tab">
							<form action="/Entertainment_Online/StatisticaVideoServlet"
								method="POST">
								<div class="row">
								<div class="col-sm-11">
								<label class="my-1 mr-2 text-white"
									for="inlineFormCustomSelectPref">Năm ?</label> <select
									class="custom-select my-1 mr-sm-2" name="year"
									id="inlineFormCustomSelectPref">
									<%
									for (int i = 2002; i < 2024; i++) {
									%>
									<option value="<%=i%>"><%=i%></option>
									<%
									}
									%>
									
								</select>
								</div>
								<div class="col-sm-1">
								
								<button type="submit" formaction="form1" class="btn btn-primary" style="margin-top: 35px;">Tìm</button>
								</div>
								</div>
							</form>
							<table class="table table-dark">
								<thead>
									<tr>
										<th scope="col">Tiêu Đề</th>
										<th scope="col">Lượt Thích</th>
										<th scope="col">Ngày Cuối</th>
										<th scope="col">Ngày Cũ Nhất</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${listFilm}">
										<tr>
											<th>${item.group}</th>
											<td>${item.likes}</td>
											<td>${item.newest}</td>
											<td>${item.oldest}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="card-footer card_footer_QL">
								<div class="row">
									<nav aria-label="Page navigation example"
										class="page_card_footer">
										<ul class="pagination">
											<span class="badge badge-pill badge-warning">1/10</span>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true"><i
														class="fa-solid fa-angles-left"></i></span>

											</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true"><i
														class="fa-solid fa-chevron-left"></i></span>

											</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true"><i
														class="fa-solid fa-chevron-right"></i></span>

											</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Next"> <span aria-hidden="true"><i
														class="fa-solid fa-angles-right"></i></span>

											</a></li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="nav-profile" role="tabpanel"
							aria-labelledby="nav-profile-tab">
							<form action="/Entertainment_Online/StatisticaVideoServlet"
								method="POST">
								<div class="row">
								<div class="col-sm-11">
								<label class="my-1 mr-2 text-white"
									for="inlineFormCustomSelectPref">Tiêu Đề ?</label> 
									<select class="custom-select my-1 mr-sm-2"
									id="inlineFormCustomSelectPref" name="title">
									<c:forEach var="item" items="${titles}">
									<option value="${item.title}">${item.title}</option>
									</c:forEach>
									
								</select>
								</div>
								<div class="col-sm-1">
								<button type="submit" formaction="form2" class="btn btn-primary" style="margin-top: 35px;">Tìm</button>
								</div>
							</div>
							</form>
							<table class="table table-dark">
								<thead>
									<tr>
										<th scope="col">Mã Video</th>
										<th scope="col">Tiêu Đề</th>
										<th scope="col">Lượt Xem</th>
										<th scope="col">Trạng Thái</th>

										
									</tr>
								</thead>
								<tbody>
								<c:forEach var="item" items="${listVideoFind}">
									<tr>
										<td>${item.id}</td>
										<td>${item.title}</td>
										<td>${item.viewss}</td>
										<td>${item.active ? 'Hoạt Động':'Ngừng Hoạt Động'}</td>

										
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<div class="card-footer card_footer_QL">
								<div class="row">
									<nav aria-label="Page navigation example"
										class="page_card_footer">
										<ul class="pagination">
											<span class="badge badge-pill badge-warning">1/10</span>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true"><i
														class="fa-solid fa-angles-left"></i></span>

											</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true"><i
														class="fa-solid fa-chevron-left"></i></span>

											</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true"><i
														class="fa-solid fa-chevron-right"></i></span>

											</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Next"> <span aria-hidden="true"><i
														class="fa-solid fa-angles-right"></i></span>

											</a></li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="nav-share" role="tabpanel"
							aria-labelledby="nav-share-tab">
							<form action="/Entertainment_Online/StatisticaVideoServlet"
								method="POST">
								<div class="row">
								<div class="col-sm-11">
								<label class="my-1 mr-2 text-white"
									for="inlineFormCustomSelectPref">Tiêu Đề ?</label> <select
									class="custom-select my-1 mr-sm-2" name="titleShare"
									id="inlineFormCustomSelectPref">
									<c:forEach var="item" items="${titles}">
									
									<option value="${item.title}">${item.title}</option>
									
									</c:forEach>
								</select>
								</div>
								<div class="col-sm-1">
								<button type="submit" formaction="form3" class="btn btn-primary" style="margin-top: 35px;">Tìm</button>
								</div>
							</div>
							</form>
							<table class="table table-dark">
								<thead>
								
									<tr>
										<th scope="col">Họ Tên Người Gửi</th>
										<th scope="col">Email Người Gửi</th>
										<th scope="col">Email Người Nhận</th>
										<th scope="col">Ngày Chia Sẻ</th>
									</tr>
								
								</thead>
								<tbody>
								<c:forEach var="userShare" items="${userShare}">
									<tr>
										<td>${userShare.fullName}</td>
										<td>${userShare.email}</td>
										<td>${userShare.emails}</td>
										<td>
										<fmt:formatDate pattern = "dd-MM-yyyy" 
        								 value = "${userShare.sharedate}" />
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<div class="card-footer card_footer_QL">
								<div class="row">
									<nav aria-label="Page navigation example"
										class="page_card_footer">
										<ul class="pagination">
											<span class="badge badge-pill badge-warning">1/10</span>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true"><i
														class="fa-solid fa-angles-left"></i></span>

											</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true"><i
														class="fa-solid fa-chevron-left"></i></span>

											</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true"><i
														class="fa-solid fa-chevron-right"></i></span>

											</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Next"> <span aria-hidden="true"><i
														class="fa-solid fa-angles-right"></i></span>

											</a></li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
					</div>
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
		</div>

		<footer class="footer-distributed">

			<div class="footer-left">
				<div class="logo_webFilm"></div>
				<h2>
					Lucas<span>TV</span>
				</h2>

				<p class="footer-links">
					<a href="#">Trang Chủ</a> | <a href="#">Phim Thiếu Nhi</a> | <a
						href="#">Phim Anime</a> | <a href="#">Phim Hài</a> | <a href="#">Phim
						Tình Cảm</a>
				</p>

				<p class="footer-company-name">© 2023 Lucas Mê Phim Hoạt Hình.</p>
			</div>

			<div class="footer-center">
				<div>
					<i class="fas fa-map-marker-alt"></i>
					<p>Khóm 6A Thị Trấn Sông Đốc Huyện Trần Văn Thời, Tỉnh Cà Mau</p>
				</div>

				<div>
					<i class="fa fa-phone"></i>
					<div class="footer-center-item">
						<p>083-856-5542</p>
						<p>078-873-1407</p>
					</div>

				</div>
				<div>
					<i class="fa fa-envelope"></i>
					<div class="footer-center-item">
						<p>
							<a href="mailto:tungto753@gmail.com">tungto753@gmail.com</a>
						</p>
						<p>
							<a href="mailto:tungtqpc04315@fpt.edu.vn">tungtqpc04315@fpt.edu.vn</a>
						</p>
					</div>

				</div>

			</div>

			<div class="footer-right">
				<p class="footer-company-about">
					<span>Liên Hệ Đến Tôi</span> Họ Và Tên: <span>Tô Quốc Tùng</span> <br>
					Lớp : <span>IT17305</span> <br> MSSV : <span>PC04315</span> <br>
					Năm Học : <span>2023-2024</span>
				</p>
				<div class="footer-icons">
					<a href="https://bom.so/gEoQL1"><i
						class="fab fa-facebook-square"></i></a> <a href="#"><i
						class="fab fa-twitter-square"></i></i></a> <a href="#"><i
						class="fab fa-instagram-square"></i></a> <a href="#"><i
						class="fab fa-linkedin"></i></a> <a href="https://bom.so/4uzADd"><i
						class="fab fa-youtube"></i></a>
				</div>
			</div>
		</footer>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>


</body>
</html>