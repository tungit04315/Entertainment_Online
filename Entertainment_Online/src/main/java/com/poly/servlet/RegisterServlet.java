package com.poly.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.UserDao;
import com.poly.entity.Users;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/jsp/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

//	public boolean kiemTra(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String typemessage = "d-none";
//		UserDao dao = new UserDao();
//		Users u = new Users();
//		List<Users> list = dao.findAll();
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getEmail().equalsIgnoreCase(request.getParameter("email"))) {
//				typemessage = "alert-danger";
//				String type = "Đăng ký thất bại";
//				String message = "Email Đã Được Đăng Ký";
//				request.setAttribute("type", type);
//				request.setAttribute("message", message);
//				return false;
//			}
//		}
//		return true;
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String typemessage = "d-none";
		if (request.getMethod().equalsIgnoreCase("POST")) {
			UserDao dao = new UserDao();
			Users u = new Users();
			try {
				typemessage = "alert-success";
				String type = "Thành Công";
				String message = "Đăng Ký Thành Công";
				request.setAttribute("type", type);
				request.setAttribute("message", message);
				BeanUtils.populate(u, request.getParameterMap());
				dao.create(u);
			} catch (Exception e) {
				typemessage = "alert-danger";
				String type = "Đăng ký thất bại";
				String message = "Tên Đăng Nhập Tồn Tại";
				request.setAttribute("type", type);
				request.setAttribute("message", message);
			}
		}
		request.setAttribute("typemessage", typemessage);
		request.getRequestDispatcher("/jsp/Register.jsp").forward(request, response);
	}

}
