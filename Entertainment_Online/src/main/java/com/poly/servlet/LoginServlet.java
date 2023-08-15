package com.poly.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.*;
import com.poly.entity.*;

@WebServlet({"/LoginServlet","/LoginServlet/SignUp/*"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}
//
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		String uri = req.getRequestURI();
//		if (uri.contains("SignIn")) {
//			doSignIn(req, resp);
//		} else if (uri.contains("SignUp")) {
//			doSignUp(req, resp);
//		} 
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (request.getMethod().equalsIgnoreCase("POST")) {
//			UserDao dao = new UserDao();
//			Users u = new Users();
//			try {
//				BeanUtils.populate(u, request.getParameterMap());
//				dao.create(u);
//				
//			} catch (Exception e) {
//				
//			}
//		}
		
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String typemessage = "d-none";
		if (request.getMethod().equalsIgnoreCase("post")) {
			UserDao dao = new UserDao();
			Users u = dao.findById(request.getParameter("username"));
			if (u == null) {
				typemessage = "alert-danger";
				String type = "Đăng Nhập Thất Bại";
				String message = "Vui Lòng Kiểm Tra Lại Thông Tin";
				request.setAttribute("type", type);
				request.setAttribute("message", message);
				request.setAttribute("typemessage", typemessage);
				request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
			} else {
				if (u.getPasswords().equalsIgnoreCase(request.getParameter("password").trim())) {
					if(u.isAdmins()==true) {
						request.getSession().setAttribute("users", u);
						response.sendRedirect("AdminsServlet");
					}else {
						request.getSession().setAttribute("users", u);
						response.sendRedirect("IndexServlet1");
					}
				} else {
					typemessage = "alert-danger";
					String type = "Đăng Nhập Thất Bại";
					String message = "Vui Lòng Kiểm Tra Mật Khẩu";
					request.setAttribute("type", type);
					request.setAttribute("message", message);
					request.setAttribute("typemessage", typemessage);
					request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
				}
			}
		}
		
	}

}
