package com.poly.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.ShareDao;
import com.poly.dao.VideoDao;
import com.poly.entity.Share;
import com.poly.entity.Users;
import com.poly.entity.Video;
import com.poly.utils.Utils;

/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/ShareServlet")
public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		request.getRequestDispatcher("/jsp/ShareVideo.jsp").forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		if(request.getMethod().equalsIgnoreCase("post")) {
			
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		
		Users u = (Users) request.getSession().getAttribute("users");
	
		
		VideoDao dao = new VideoDao();
		Video v = dao.findByTitle(title);
		
		Random random = new Random();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("ddMMyyyyss");
        String formatS = simpleDateFormat.format(date);
        
        int ID = random.nextInt(10000) + Integer.parseInt(formatS);
		
        
        try {
        	
        	
        	Share share = new Share();
            share.setId(ID);
            share.setUser(u);
            share.setVideo(v);
            share.setShareDate(date);
            share.setEmails(email);
            
            ShareDao Sharedao = new ShareDao();
            Sharedao.create(share);
        	
        	Properties props = new Properties();

    		props.put("mail.smtp.auth", "true");
    		props.put("mail.smtp.starttls.enable", "true");
    		props.put("mail.smtp.host", "smtp.gmail.com");
    		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    		props.put("mail.smtp.port", "587");
    		props.put("mail.mime.charset", "utf-8");
    		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

    		Session sess = Session.getInstance(props, new Authenticator() {

    			protected PasswordAuthentication getPasswordAuthentication() {
    				String username = "tungto753@gmail.com";
    				String password = "hprkbqfoagwlfuga";
    				return new PasswordAuthentication(username, password);
    			}
    		});

    		Message message = new MimeMessage(sess);
    		message.setHeader("Content-Type", "text/plain; charset=UTF-8");
    		message.setFrom(new InternetAddress("tungto753@gmail.com"));
    		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("totung753@gmail.com"));
    		message.setSubject("WEB LUCAS TV");

    		BodyPart messageBodyPart = new MimeBodyPart();

    		messageBodyPart.setText("LINK VIDEO: "+"https://www.youtube.com/watch?v=" + v.getId());

    		Multipart multipart = new MimeMultipart();

    		multipart.addBodyPart(messageBodyPart);

    		messageBodyPart = new MimeBodyPart();
    		String filename = "E:\\FPT Polytechnic\\JAVA_4\\ASM\\IT17305_TungTQPC04315_ASM_GD3\\Entertainment_Online\\src\\main\\webapp\\img\\logoweb.png";
    		DataSource source = new FileDataSource(filename);
    		messageBodyPart.setDataHandler(new DataHandler(source));
    		messageBodyPart.setFileName(filename);
    		multipart.addBodyPart(messageBodyPart);

    		message.setContent(multipart);

    		Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		
//        
        EntityManager em = Utils.getEntityManager();
		Query query = em.createNamedQuery("Report.random10");
		List<Video> list = query.getResultList();
		
		
		request.setAttribute("randoms", list);
		request.setAttribute("item", v);
		request.setAttribute("view", "/jsp/VideoDetail.jsp");
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		
	}
//	request.getRequestDispatcher("/jsp/ShareVideo.jsp").forward(request, response);
	}

	

}
