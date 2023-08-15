package com.poly.servlet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.dao.FavoriteDao;
import com.poly.dao.VideoDao;
import com.poly.entity.Favorite;
import com.poly.entity.Users;
import com.poly.entity.Video;
import com.poly.utils.Utils;

import java.io.IOException;
import java.util.List;

@WebServlet({ "/VideoLike", "/VideoLike/deleteLike/*" })
public class VideoLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoLikeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("view", "/jsp/VideoLike.jsp");
		

		Users u = (Users) request.getSession().getAttribute("users");
		
		
		try {
			if(u == null) {
				List<Favorite> favorites = null;
				request.setAttribute("favorites", favorites);
			}else {
				List<Favorite> favorites = u.getFavorites();
				request.setAttribute("favorites", favorites);
			}

			

//			request.setAttribute("favorites", favorites);
			request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
