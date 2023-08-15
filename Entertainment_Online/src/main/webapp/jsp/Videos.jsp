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
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
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
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          Tài Khoản
					        </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="./ForgotPassword">Quên Mật Khẩu</a> 
                                <a class="dropdown-item" href="./UpdatePassword">Đổi Mật Khẩu</a> 
                                <a class="dropdown-item" href="./UpdateProfileServlet">Cập Nhật Thông Tin</a> 
                                <a class="dropdown-item" href="./VideoLike">Video Yêu Thích</a>
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



			<div class="container_film">
                <div class="title_film" style="margin-top: 10px;">
                    <h3 class="text-warning"><i class="fa-solid fa-grip-lines-vertical"></i> Quản Lý Video</h3>
                </div>
                <div class="col-sm-12">
                    <nav>
                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                            <a class="nav-item nav-link  ${kt ? 'active':''}" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Cập Nhật</a>
                            <a class="nav-item nav-link  ${kt ? '':'active'}" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Danh Sách</a>
                        </div>
                    </nav>
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show ${kt ? 'show active':''}" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                            <form class="formUpdate" action="/VideoListServlet"
								method="post">
                                <div class="row">
                                    <div class="col-sm-4">
                                        <img src="${form.poster}" alt="..." class="img-thumbnail">
                                    </div>
                                    <div class="col-sm-8">
                                    <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Mã video</label>
                                            <input type="text" name="id" value="${form.id}" class="form-control" placeholder="Mã video">
                                        </div>                                
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Link video</label>
                                            <input type="text" name="href" value="${form.href}" class="form-control" placeholder="Link video">
                                        </div>
                                    </div>
                                    </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Tiêu đề video</label>
                                            <input type="text" name="title" value="${form.title}" class="form-control" placeholder="Tiêu đề video">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Lượt xem</label>
                                            <input type="number" name="viewss" class="form-control" value="${form.viewss}" >
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="active" ${form.active?'checked':''} id="exampleRadios1" value="true">
                                            <label class="form-check-label" for="exampleRadios1">
                                              Hoạt động
                                            </label>
                                            <input class="form-check-input" type="radio" name="active" ${form.active?'':'checked'} id="exampleRadios2" value="false">
                                            <label class="form-check-label" for="exampleRadios2">
                                              Ngừng Hoạt động
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Mô tả video</label>
                                            <textarea name="descriptions" class="form-control" rows="5">${form.descriptions}</textarea>
                                           <div class="form-group">
                                            <label for="exampleInputPassword1">Ảnh Video</label>
                                            <input type="text" name="poster" value="${form.poster}" class="form-control" placeholder="Ảnh video">
                                        </div>
                                        </div>
                                        <div class="row">
                                            <button type="submit" class="btn btn-primary" formaction="create">Thêm</button>
                                            <button type="submit" class="btn btn-primary" formaction="updatev">Cập Nhật</button>
                                            <button type="submit" class="btn btn-primary" formaction="deletev">Xoá</button>
                                            <button type="submit" class="btn btn-primary" formaction="new">Làm mới</button>
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="tab-pane fade ${kt ? '':'show active'}" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                            <table class="table table-dark">
                                <thead>
                                    <tr>
                                        <th scope="col">Mã Video</th>
                                        <th scope="col">Tiêu Đề</th>
                                        <th scope="col">Lượt Xem</th>
                                        <th scope="col">Trạng Thái</th>

                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${items}">
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>${item.title}</td>
                                        <td>${item.viewss}</td>
                                        <td>${item.active ? 'Hoạt Động':'Ngừng Hoạt Động'}</td>

                                        <td><a href="editv?id=${item.id}">Cập Nhật</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
					<div class="alert ${typemessage} ">
					<strong>${type}!</strong> ${message}
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