package com.poly.servlet;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
import com.poly.entity.Share;
import com.poly.entity.Users;
import com.poly.entity.Video;
import com.poly.utils.Utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

@WebServlet("/VideoDetail")
public class VideoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String href = request.getParameter("id");
		HttpSession s = request.getSession();

		switch (action) {
		case "watch":
			doGetWatch(s, href, request, response);
			break;
		case "like":
			doGetLike(s, href, request, response);
			break;
//		case "share":
//			doGetShare(s, href, request, response);
//			break;
		}
		
	}

	public void doGetWatch(HttpSession s, String href, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoDao dao = new VideoDao();
		Video v = dao.findByHref(href);
		request.setAttribute("item", v);
		
		EntityManager em = Utils.getEntityManager();
		Query query = em.createNamedQuery("Report.random10");
		List<Video> list = query.getResultList();
		request.setAttribute("randoms", list);
		
		request.setAttribute("view", "/jsp/VideoDetail.jsp");
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}
	
	public void doGetLike(HttpSession s, String href, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users u = (Users) request.getSession().getAttribute("users");
		
		VideoDao dao = new VideoDao();
		Video v = dao.findByHref(href);
		
		Random random = new Random();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("ddMMyyyyss");
        String formatS = simpleDateFormat.format(date);
        
        int ID = random.nextInt(10000) + Integer.parseInt(formatS);
		
		Favorite entity = new Favorite();
		entity.setId(ID);
		entity.setUser(u);
		entity.setVideo(v);
		entity.setLikeDate(new Date());
		
		FavoriteDao favoriteDao = new FavoriteDao();
		favoriteDao.create(entity);
		
		EntityManager em = Utils.getEntityManager();
		Query query = em.createNamedQuery("Report.random10");
		List<Video> list = query.getResultList();
		
		
		request.setAttribute("randoms", list);
		request.setAttribute("item", v);
		request.setAttribute("view", "/jsp/VideoDetail.jsp");
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

//	protected void doGetShare(HttpSession s, String href, HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		Users u = (Users) request.getSession().getAttribute("users");
//		String email = request.getParameter("email");
//		
//		VideoDao dao = new VideoDao();
//		Video v = dao.findByHref(href);
//		
//		Random random = new Random();
//		Date date = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
//        simpleDateFormat.applyPattern("ddMMyyyyss");
//        String formatS = simpleDateFormat.format(date);
//        
//        int ID = random.nextInt(10000) + Integer.parseInt(formatS);
//		
//        Share share = new Share();
//        share.setId(ID);
//        share.setUser(u);
//        share.setVideo(v);
//        share.setShareDate(date);
//        share.setEmails(email);
//        
//        try {
//        	Properties props = new Properties();
//
//    		props.put("mail.smtp.auth", "true");
//    		props.put("mail.smtp.starttls.enable", "true");
//    		props.put("mail.smtp.host", "smtp.gmail.com");
//    		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//    		props.put("mail.smtp.port", "587");
//    		props.put("mail.mime.charset", "utf-8");
//    		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//
//    		Session sess = Session.getInstance(props, new Authenticator() {
//
//    			protected PasswordAuthentication getPasswordAuthentication() {
//    				String username = "tungto753@gmail.com";
//    				String password = "hprkbqfoagwlfuga";
//    				return new PasswordAuthentication(username, password);
//    			}
//    		});
//
//    		Message message = new MimeMessage(sess);
//    		message.setHeader("Content-Type", "text/plain; charset=UTF-8");
//    		message.setFrom(new InternetAddress("tungto753@gmail.com"));
//    		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//    		message.setSubject("WEB LUCAS TV");
//
//    		BodyPart messageBodyPart = new MimeBodyPart();
//
//    		messageBodyPart.setText("https://www.youtube.com/watch?v=" + href);
//
//    		Multipart multipart = new MimeMultipart();
//
//    		multipart.addBodyPart(messageBodyPart);
//
//    		messageBodyPart = new MimeBodyPart();
//    		String filename = "E:\\FPT Polytechnic\\JAVA_4\\ASM\\IT17305_TungTQPC04315_ASM_GD3\\Entertainment_Online\\src\\main\\webapp\\img\\logoweb.png";
//    		DataSource source = new FileDataSource(filename);
//    		messageBodyPart.setDataHandler(new DataHandler(source));
//    		messageBodyPart.setFileName(filename);
//    		multipart.addBodyPart(messageBodyPart);
//
//    		message.setContent(multipart);
//
//    		Transport.send(message);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        
//        
//        EntityManager em = Utils.getEntityManager();
//		Query query = em.createNamedQuery("Report.random10");
//		List<Video> list = query.getResultList();
//		
//		
//		request.setAttribute("randoms", list);
//		request.setAttribute("item", v);
//		request.setAttribute("view", "/jsp/VideoDetail.jsp");
//		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
//	}

}
