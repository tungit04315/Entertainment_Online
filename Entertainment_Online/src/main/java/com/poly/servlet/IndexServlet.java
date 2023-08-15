package com.poly.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.poly.dao.*;
import com.poly.entity.*;

@WebServlet("/IndexServlet1")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	String uri = request.getRequestURI();
//    	if(uri.contains("home")) {
//    		request.setAttribute("view", "/jsp/home.jsp");
//    	}else if(uri.contains("VideoDetail")) {
//    		request.setAttribute("view", "/jsp/VideoDetail.jsp");
//    	}else if(uri.contains("VideoLike")) {
//    		request.setAttribute("view", "/jsp/VideoLike.jsp");
//    	}
//    	request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDao dao = new VideoDao();
			List<Video> list = dao.findAll();

			request.setAttribute("view", "/jsp/home.jsp");
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
