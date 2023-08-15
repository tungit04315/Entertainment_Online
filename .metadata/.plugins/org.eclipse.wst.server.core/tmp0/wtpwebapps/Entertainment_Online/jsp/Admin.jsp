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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body class="body">
	<div class="container-fuild">
		<div class="banner">
			<div class="bg"></div>
			<div class="content">Hòn Đảo Ma Quái (IsLand)</div>
		</div>
		<div class="container">
			<header>
                <div class="logo">
                    <a href="./AdminsServlet">ADMINISTRATION TOOL</a>
                </div>
                <nav class="signin">
                    <ul class="signin_item_links">
                        <li><a href="./AdminsServlet">Trang Chủ</a></li>
                        <li><a href="./VideoListServlet">Videos</a></li>
                        <li><a href="./UserServlet">Tài Khoản Người Dùng</a></li>
                        <li><a href="./StatisticaVideoServlet">Thống Kê</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          Tài Khoản
					        </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="./ForgotPassword">Quên Mật Khẩu</a>
                                <a class="dropdown-item" href="./UpdatePassword">Đổi Mật Khẩu</a>
                                <a class="dropdown-item" href="./UpdateProfileServlet1">Cập Nhật Thông Tin</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="./Logout">Đăng Xuất</a>
                            </div>
                        </li>
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
			<div class="library allowActive">
				<div class="item"></div>
				<div class="item"></div>
				<div class="item"></div>
				<div class="item"></div>
			</div>
			<div class="des allowActive">Island kể về cuộc chiến giữa bộ ba
				nhân vật chính với loài quỷ dữ. Đầu tiên là linh mục trẻ tuổi tài
				cao Yohan (Cha Eun Woo). Tài năng diệt quỷ của Yohan đã được ghi
				nhận bởi vô số thành tích. Yohan vốn đang sống ở Mỹ, được triệu tập
				quay về Hàn để thực hiện sứ mệnh trừ tà, giải cứu thế giới. Bên cạnh
				đó, anh còn được giao trọng trách bảo vệ Won Mi Ho, người được cho
				là tái sinh của thần nữ. Won Mi Ho (Lee Da Hee) là ái nữ duy nhất
				của tập đoàn Daehan giàu có và hùng mạnh. Mi Ho là cô tiểu thư mạnh
				mẽ, bản lĩnh, đang từng bước thể hiện bản thân để giành lấy quyền
				quản lý tập đoàn. Trong một lần bị gài bẫy, cô đã bị cha mình cắt
				chức và đưa đi lánh mặt một thời gian. Cơ duyên này đã đưa đẩy Mi Ho
				đặt chân đến Tamra. Khi vừa đặt chân đến đảo Jeju, Mi Ho đã bị dục
				quỷ tấn công. Giữa lúc nguy hiểm, cô được Van (Kim Nam Gil) giải
				cứu. Van cảnh báo Mi Ho rằng loại dục quỷ này sẽ đi theo tấn công cô
				mọi lúc mọi nơi. Ngược dòng thời gian, có thể thấy mối lương duyên
				của Van và Mi Ho đã có từ tiền kiếp. Van vốn là đứa bé duy nhất sống
				sót trong cuộc tấn công tàn ác của dục quỷ. Sau khi được cứu, các
				pháp sư đã đưa dòng máu quỷ vào cơ thể Van, khiến anh trở thành nửa
				người nửa quỷ. Cũng nhờ đó, Van có khả năng phi thường, có thể chiến
				đấu và tiêu diệt dục quỷ. Mi Ho kiếp trước là thần nữ, người có khả
				năng đối đầu với quỷ dữ để cứu sống nhân loại. Sứ mệnh thiêng liêng
				đã khiến hai đứa trẻ Van và Mi Ho gặp nhau nhưng rồi phải chia xa.
				Van vẫn luôn chờ đợi lời hẹn ước trở về của thần nữ. Tuy nhiên, khi
				trở về trong thân xác tiểu thư Mi Ho, cô đã không còn nhớ gì về tiền
				kiếp cũng như sứ mệnh của mình. Trong khi đó, lũ quỷ ngày càng tàn
				bạo. Liệu bộ ba Van, linh mục Yohan và Mi Ho có hợp sức để chống lại
				các thế lực tà ác, giải cứu nhân loại? Mối lương duyên tiền kiếp
				giữa Mi Ho và Van có được tiếp nối ở kiếp này?</div>

				<jsp:include page="${view}"></jsp:include>

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

	<script src="js/index.js"></script>
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