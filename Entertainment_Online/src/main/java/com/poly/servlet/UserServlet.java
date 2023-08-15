package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.UserDao;
import com.poly.entity.Users;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/edit/*", "/update/*", "/delete/*" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String typemessage = "d-none";
		boolean kt = false;
		Users user = new Users();
		UserDao dao = new UserDao();
		if (uri.contains("edit")) {
//			String id = uri.substring(uri.lastIndexOf("?=") + 1);
			String id = req.getParameter("id");
			user = dao.findById(id);
			kt = true;
		} else if (uri.contains("delete")) {
			String id = req.getParameter("id");
			dao.delete(id);
			System.out.println("delete");
		} else if (uri.contains("update")) {
			try {
				BeanUtils.populate(user, req.getParameterMap());
				dao.update(user);
				typemessage = "alert-success";
				String type = "Thành Công";
				String message = "Cập Nhật Thành Công";
				req.setAttribute("type", type);
				req.setAttribute("message", message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(uri);
		req.setAttribute("kt", kt);
		req.setAttribute("form", user);
		req.setAttribute("items", dao.findAll());
		req.setAttribute("typemessage", typemessage);
		req.getRequestDispatcher("/jsp/Users.jsp").forward(req, resp);
	}

}
