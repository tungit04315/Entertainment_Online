/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2023-04-12 14:46:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ShareVideo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Phim Hay Lucas TV</title>\r\n");
      out.write("<link rel=\"icon\" type=\"image/x-icon\" href=\"img/iconLogo.png\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/index.css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/Login.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"\r\n");
      out.write("	integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"body\">\r\n");
      out.write("	<div class=\"container-fuild\">\r\n");
      out.write("\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<header>\r\n");
      out.write("				<div class=\"logo\">\r\n");
      out.write("					<a href=\"./IndexServlet1\">ENTERTAIMENT ONLINE</a>\r\n");
      out.write("				</div>\r\n");
      out.write("				<nav class=\"signin\">\r\n");
      out.write("					<ul class=\"signin_item_links\">\r\n");
      out.write("						<li><a href=\"./IndexServlet1\">Trang Chủ</a></li>\r\n");
      out.write("\r\n");
      out.write("						<li><a href=\"#\">Anime</a></li>\r\n");
      out.write("						<li><a href=\"#\">Hài</a></li>\r\n");
      out.write("						<li><a href=\"#\">Tình Cảm</a></li>\r\n");
      out.write("						<li class=\"nav-item dropdown\"><a\r\n");
      out.write("							class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\r\n");
      out.write("							role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("							aria-expanded=\"false\"> Tài Khoản </a>\r\n");
      out.write("							<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("								<a class=\"dropdown-item\" href=\"./ForgotPassword\">Quên Mật Khẩu</a> <a\r\n");
      out.write("									class=\"dropdown-item\" href=\"./UpdatePassword\">Đổi Mật Khẩu</a> <a\r\n");
      out.write("									class=\"dropdown-item\" href=\"./UpdateProfileServlet1\">Cập Nhật Thông Tin</a> <a\r\n");
      out.write("									class=\"dropdown-item\" href=\"./VideoLike\">Video Yêu Thích</a>\r\n");
      out.write("								<div class=\"dropdown-divider\"></div>\r\n");
      out.write("								<a class=\"dropdown-item\" href=\"./Logout\">Đăng Xuất</a>\r\n");
      out.write("							</div></li>\r\n");
      out.write("						<a class=\"btn button\" href=\"./LoginServlet\">Đăng Nhập</a>\r\n");
      out.write("						<a class=\"btn button\" href=\"./Register\">Đăng Ký</a>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</nav>\r\n");
      out.write("			</header>\r\n");
      out.write("			<nav class=\"nav_item_links\">\r\n");
      out.write("				<ul>\r\n");
      out.write("					<li><a href=\"https://bom.so/4uzADd\">Youtube</a></li>\r\n");
      out.write("					<li><a href=\"https://bom.so/gEoQL1\">Facebook</a></li>\r\n");
      out.write("					<li><a href=\"https://www.instagram.com/lucasit041001/\">Intagram</a>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li><a href=\"http://tungle04.bio.link/\">Website</a></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<div class=\"container_form\">\r\n");
      out.write("                <input id=\"register_toggle\" type=\"checkbox\">\r\n");
      out.write("                <div class=\"alert ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${typemessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" \">\r\n");
      out.write("					<strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("!</strong> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("                <div class=\"slider_form\">\r\n");
      out.write("                    <form class=\"form\" action=\"/Entertainment_Online/ShareServlet\" method=\"post\">\r\n");
      out.write("                        <i class=\"fa-solid fa-clapperboard\"></i>\r\n");
      out.write("                        <span class=\"title\">Chia Sẻ Video</span>\r\n");
      out.write("                        <div class=\"form_control\">\r\n");
      out.write("                            <input required=\"\" name=\"email\" class=\"input\" type=\"email\">\r\n");
      out.write("                            <label class=\"label\">Email</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form_control\">\r\n");
      out.write("                            <input required=\"\" name=\"title\" class=\"input\" type=\"text\">\r\n");
      out.write("                            <label class=\"label\">Tiêu Đề</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <button class=\"btn_ok\" type=\"submit\">Gửi</button>\r\n");
      out.write("                        \r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<footer class=\"footer-distributed\">\r\n");
      out.write("\r\n");
      out.write("			<div class=\"footer-left\">\r\n");
      out.write("				<div class=\"logo_webFilm\"></div>\r\n");
      out.write("				<h2>\r\n");
      out.write("					Lucas<span>TV</span>\r\n");
      out.write("				</h2>\r\n");
      out.write("\r\n");
      out.write("				<p class=\"footer-links\">\r\n");
      out.write("					<a href=\"#\">Trang Chủ</a> | <a href=\"#\">Phim Thiếu Nhi</a> | <a\r\n");
      out.write("						href=\"#\">Phim Anime</a> | <a href=\"#\">Phim Hài</a> | <a href=\"#\">Phim\r\n");
      out.write("						Tình Cảm</a>\r\n");
      out.write("				</p>\r\n");
      out.write("\r\n");
      out.write("				<p class=\"footer-company-name\">© 2023 Lucas Mê Phim Hoạt Hình.</p>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"footer-center\">\r\n");
      out.write("				<div>\r\n");
      out.write("					<i class=\"fas fa-map-marker-alt\"></i>\r\n");
      out.write("					<p>Khóm 6A Thị Trấn Sông Đốc Huyện Trần Văn Thời, Tỉnh Cà Mau</p>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("				<div>\r\n");
      out.write("					<i class=\"fa fa-phone\"></i>\r\n");
      out.write("					<div class=\"footer-center-item\">\r\n");
      out.write("						<p>083-856-5542</p>\r\n");
      out.write("						<p>078-873-1407</p>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("				<div>\r\n");
      out.write("					<i class=\"fa fa-envelope\"></i>\r\n");
      out.write("					<div class=\"footer-center-item\">\r\n");
      out.write("						<p>\r\n");
      out.write("							<a href=\"mailto:tungto753@gmail.com\">tungto753@gmail.com</a>\r\n");
      out.write("						</p>\r\n");
      out.write("						<p>\r\n");
      out.write("							<a href=\"mailto:tungtqpc04315@fpt.edu.vn\">tungtqpc04315@fpt.edu.vn</a>\r\n");
      out.write("						</p>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"footer-right\">\r\n");
      out.write("				<p class=\"footer-company-about\">\r\n");
      out.write("					<span>Liên Hệ Đến Tôi</span> Họ Và Tên: <span>Tô Quốc Tùng</span> <br>\r\n");
      out.write("					Lớp : <span>IT17305</span> <br> MSSV : <span>PC04315</span> <br>\r\n");
      out.write("					Năm Học : <span>2023-2024</span>\r\n");
      out.write("				</p>\r\n");
      out.write("				<div class=\"footer-icons\">\r\n");
      out.write("					<a href=\"https://bom.so/gEoQL1\"><i\r\n");
      out.write("						class=\"fab fa-facebook-square\"></i></a> <a href=\"#\"><i\r\n");
      out.write("						class=\"fab fa-twitter-square\"></i></i></a> <a href=\"#\"><i\r\n");
      out.write("						class=\"fab fa-instagram-square\"></i></a> <a href=\"#\"><i\r\n");
      out.write("						class=\"fab fa-linkedin\"></i></a> <a href=\"https://bom.so/4uzADd\"><i\r\n");
      out.write("						class=\"fab fa-youtube\"></i></a>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</footer>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"\r\n");
      out.write("		integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\"\r\n");
      out.write("		integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\"\r\n");
      out.write("		integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
