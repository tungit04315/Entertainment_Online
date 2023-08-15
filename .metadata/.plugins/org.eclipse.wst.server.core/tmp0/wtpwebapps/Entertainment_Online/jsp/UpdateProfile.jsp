<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Phim Hay Lucas TV</title>
<link rel="icon" type="image/x-icon" href="img/iconLogo.png">
<link rel="stylesheet" href="css/index.css">

<link rel="stylesheet" href="css/Login.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body class="body">
	<div class="container-fuild">

		<div class="container">
			<header>
				<div class="logo">
					<a href="./IndexServlet1">ENTERTAIMENT ONLINE</a>
				</div>
				<nav class="signin">
					<ul class="signin_item_links">
						<li><a href="./IndexServlet1">Trang Chủ</a></li>

						<li><a href="#">Anime</a></li>
						<li><a href="#">Hài</a></li>
						<li><a href="#">Tình Cảm</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Tài Khoản </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="./ForgotPassword">Quên Mật Khẩu</a> <a
									class="dropdown-item" href="./UpdatePassword">Đổi Mật Khẩu</a> <a
									class="dropdown-item" href="./UpdateProfileServlet">Cập Nhật Thông Tin</a> <a
									class="dropdown-item" href="./VideoLike">Video Yêu Thích</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="./Logout">Đăng Xuất</a>
							</div></li>
						<a class="btn button" href="./LoginServlet">Đăng Nhập</a>
						<a class="btn button" href="./Register">Đăng Ký</a>
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



			<div class="container_form">
                <input id="register_toggle" type="checkbox">
                <div class="alert ${typemessage} ">
					<strong>${type}!</strong> ${message}
				</div>
                <div class="slider_form">
                    <form class="form" action="/Entertainment_Online/UpdateProfileServlet1" method="post">
                        <i class="fa-solid fa-clapperboard"></i>
                        <span class="title">Cập Nhật Thông Tin</span>
                        <div class="form_control">
                            <input required="" name="id" class="input" type="text" value="${item.id}" >
                            <label class="label">Tên Đăng Nhập</label>
                        </div>
                        <div class="form_control">
                            <input required="" name="passwords" class="input" type="password" value="${item.passwords}">
                            <label class="label">Mật Khẩu</label>
                        </div>
                        <div class="form_control">
                            <input required="" name="fullName" class="input" type="text" value="${item.fullName}">
                            <label class="label">Họ Và Tên</label>
                        </div>
                        <div class="form_control">
                            <input required="" name="email" class="input" type="email" value="${item.email}">
                            <label class="label">Email</label>
                        </div>

                        <button class="btn_ok">Cập Nhật</button>
                    </form>
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