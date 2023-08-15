package com.poly.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.UserDao;
import com.poly.entity.Users;

@WebServlet("/UpdateProfileServlet1")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users u = (Users) request.getSession().getAttribute("users");
		
		request.setAttribute("item", u);
		request.getRequestDispatcher("/jsp/UpdateProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typemessage = "d-none";

		if (request.getMethod().equalsIgnoreCase("POST")) {
			UserDao dao = new UserDao();
			Users u = new Users();
			try {
				BeanUtils.populate(u, request.getParameterMap());
				dao.update(u);
				typemessage = "alert-success";
				String type = "Cập Nhật Thành Công";
				String message = "Cập Nhật Thông tin Thành Công";
				request.setAttribute("type", type);
				request.setAttribute("message", message);
			} catch (Exception e) {
				typemessage = "alert-danger";
				String type = "Cập nhật thất bại";
				String message = "Vui lòng kiểm tra lại thông tin";
				request.setAttribute("type", type);
				request.setAttribute("message", message);
			}
		}
		
		request.setAttribute("typemessage", typemessage);
		
		request.getRequestDispatcher("/jsp/UpdateProfile.jsp").forward(request, response);
	}

}
