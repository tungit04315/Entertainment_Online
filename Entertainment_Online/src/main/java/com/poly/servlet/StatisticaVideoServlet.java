package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.VideoDao;
import com.poly.entity.*;
import com.poly.utils.Utils;

/**
 * Servlet implementation class StatisticaVideoServlet
 */
@WebServlet({ "/StatisticaVideoServlet", "/form1/*", "/form2/*", "/form3/*"})
public class StatisticaVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticaVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		EntityManager em = Utils.getEntityManager();
//		Query query = em.createNamedQuery("Report.year");
//		List<Report> list = query.getResultList();
//		
//		request.setAttribute("listFilm", list);
		VideoDao dao = new VideoDao();
		
		request.setAttribute("titles", dao.findAll());
		
		request.getRequestDispatcher("/jsp/StatisticalVideo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("form1")) {
			VideoDao dao = new VideoDao();
			
			request.setAttribute("titles", dao.findAll());
			this.findByKeywordYear(request, response);
		}
		if (uri.contains("form2")) {
			VideoDao dao = new VideoDao();
			
			request.setAttribute("titles", dao.findAll());
			this.findByTitle(request, response);
		}
		if (uri.contains("form3")) {
			VideoDao dao = new VideoDao();
			
			request.setAttribute("titles", dao.findAll());
			this.findShare(request, response);
		}
	}
	
	private void findByKeywordYear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = Utils.getEntityManager();
		try {
			Integer nam = Integer.valueOf(request.getParameter("year"));

			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Report.favoriteByYear");

			query.setParameter("Year", nam);
			List<Video> list = query.getResultList();
			request.setAttribute("listFilm", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/jsp/StatisticalVideo.jsp").forward(request, response);
	}

	private void findByTitle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EntityManager em = Utils.getEntityManager();
		
		String title = request.getParameter("title");
		TypedQuery<Video> query = em.createNamedQuery("Video.findByKeyword", Video.class);
		query.setParameter("keyword", "%" + title + "%");

		List<Video> list = query.getResultList();
		
		VideoDao dao = new VideoDao();
		
		request.setAttribute("listVideoFind", list);
		request.setAttribute("titles", dao.findAll());
		request.getRequestDispatcher("/jsp/StatisticalVideo.jsp").forward(request, response);
	}

	private void findShare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EntityManager em = Utils.getEntityManager();
		
		
		try {
			String titleShare = request.getParameter("titleShare");
			VideoDao vdDao = new VideoDao();
			Video vi = vdDao.findByTitle(titleShare);
			System.out.println(vi);
			
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Report.videoShareByID");
			System.out.println(vi.getId());
			query.setParameter("VideoID", vi.getId());
			List<Share> list = query.getResultList();
			request.setAttribute("userShare", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/jsp/StatisticalVideo.jsp").forward(request, response);
	}

}
