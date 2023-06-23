package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connector.Connect;
import com.dao.UserDAO;
import com.entities.Message;
import com.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			UserDAO dao=new UserDAO(Connect.getCon() );
			User user=dao.login(email,password);
			HttpSession session=req.getSession();
			if(user!=null) {
				Message msg = new Message("Congrats! Login successfull...", "alert-success");
				session.setAttribute("msg", msg);
				session.setAttribute("userobj", user);
				res.sendRedirect("index.jsp");
			}else {
				Message msg = new Message("Email or Password is Wrong...", "alert-danger");
				session.setAttribute("msg", msg);
				res.sendRedirect("login_page.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
