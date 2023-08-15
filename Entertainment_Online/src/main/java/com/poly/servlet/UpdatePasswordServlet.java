package com.poly.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.poly.dao.UserDao;
import com.poly.entity.Users;

@WebServlet("/UpdatePassword")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users u = (Users) request.getSession().getAttribute("users");
		
		request.setAttribute("item", u);
		request.getRequestDispatcher("/jsp/UpdatePassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(request.getMethod().equalsIgnoreCase("post")) {
		String typemessage = "d-none";
		String id = request.getParameter("id");
		String newPass = request.getParameter("newPassword");
		String confirmlPass = request.getParameter("confirmNewPassword");
		
		UserDao dao = new UserDao(); 
		Users u = dao.findById(id);
		
		if(u == null) {
			typemessage = "alert-danger";
			String type = "Đổi Mật Khẩu Thất Bại";
			String message = "Vui Lòng Kiểm Tra Lại Thông Tin";
			request.setAttribute("type", type);
			request.setAttribute("message", message);
		}else if(newPass.equalsIgnoreCase(confirmlPass)) {
			typemessage = "alert-success";
			String type = "Đổi Mật Khẩu Thành Công";
			String message = "Cập Nhật Mật Khẩu Mới Thành Công";
			request.setAttribute("type", type);
			request.setAttribute("message", message);
			u.setPasswords(request.getParameter("newPassword"));
		
			dao.update(u);
		}else {
			typemessage = "alert-danger";
			String type = "Đổi Mật Khẩu Thất Bại";
			String message = "Mật Khẩu Mới Không Khớp";
			request.setAttribute("type", type);
			request.setAttribute("message", message);
		}
		
		
		request.setAttribute("typemessage", typemessage);
		request.getRequestDispatcher("/jsp/UpdatePassword.jsp").forward(request, response);
	}
	}

}
