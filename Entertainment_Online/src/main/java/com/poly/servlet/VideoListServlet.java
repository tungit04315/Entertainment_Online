package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.*;
import com.poly.entity.*;

@MultipartConfig
@WebServlet({ "/VideoListServlet", "/new/*", "/updatev/*", "/deletev/*", "/create/*" ,"/editv/*"})
public class VideoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VideoListServlet() {
        super();
    }

    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String poster = req.getParameter("poster");
		String typemessage = "d-none";
		boolean kt = false;
		Video v = new Video();
		VideoDao dao = new VideoDao();
		if (uri.contains("edit")) {
			String id = req.getParameter("id");
			v = dao.findById(id);
			kt = true;
		} else if (uri.contains("delete")) {
			String id = req.getParameter("id");
			dao.delete(id);
		} else if (uri.contains("updatev")) {
			try {
				BeanUtils.populate(v, req.getParameterMap());
				dao.update(v);
				typemessage = "alert-success";
				String type = "Thành Công";
				String message = "Cập Nhật Thành Công";
				req.setAttribute("type", type);
				req.setAttribute("message", message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("create")) {
			try {
				BeanUtils.populate(v, req.getParameterMap());
				dao.create(v);
				typemessage = "alert-success";
				String type = "Thành Công";
				String message = "Thêm Thành Công";
				req.setAttribute("type", type);
				req.setAttribute("message", message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(uri.contains("new")){
			req.setAttribute("form", null);
		}
		System.out.println(uri);
//		req.setAttribute("", poster);
		req.setAttribute("kt", kt);
		req.setAttribute("form", v);
		req.setAttribute("items", dao.findAll());
		req.setAttribute("typemessage", typemessage);
		req.getRequestDispatcher("/jsp/Videos.jsp").forward(req, resp);
	}

}
