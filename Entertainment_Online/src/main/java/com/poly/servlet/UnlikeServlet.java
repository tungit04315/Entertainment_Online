package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
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

/**
 * Servlet implementation class UnlikeServlet
 */
@WebServlet("/UnlikeServlet")
public class UnlikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnlikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = Utils.getEntityManager();

		Users u = (Users) request.getSession().getAttribute("users");
		String action = request.getParameter("action");
		String maVD = request.getParameter("id");
		switch (action) {
		case "unlike":
			doUnLike(request.getSession(), maVD, request, response);
			break;
		}
		
		
	}

	public void doUnLike(HttpSession s, String maVD, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavoriteDao dao = new FavoriteDao();
		Users u = (Users) request.getSession().getAttribute("users");
		

		dao.delete(u.getId(), maVD);
		
		
		List<Favorite> favorites = u.getFavorites();
		request.setAttribute("view", "/jsp/VideoLike.jsp");
		request.setAttribute("favorites", favorites);
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
