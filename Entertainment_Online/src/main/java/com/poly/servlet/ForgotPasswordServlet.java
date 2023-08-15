package com.poly.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

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

import com.poly.dao.UserDao;
import com.poly.entity.Users;

@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgotPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/ForgotPassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String typemessage = "d-none";
		if (request.getMethod().equalsIgnoreCase("POST")) {
			try {
				UserDao dao = new UserDao();
				Users u = dao.findById(id);
				if (u == null) {
					typemessage = "alert-danger";
					String type = "Gửi Yêu Cầu Thất Bại";
					String message = "Vui Lòng Kiểm Tra Lại Thông Tin";
					request.setAttribute("type", type);
					request.setAttribute("message", message);
//					request.setAttribute("typemessage", typemessage);
				} else {
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
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
					message.setSubject("This Is Your Account Password");

					BodyPart messageBodyPart = new MimeBodyPart();

					messageBodyPart.setText("Password is : " + u.getPasswords());

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

					typemessage = "alert-success";
					String type = "Gửi Yêu Cầu Thành Công";
					String messages = "Vui Lòng Kiểm Tra Lại Email Tài Khoản";
					request.setAttribute("type", type);
					request.setAttribute("message", messages);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("typemessage", typemessage);
		request.getRequestDispatcher("/jsp/ForgotPassword.jsp").forward(request, response);

	}

}
