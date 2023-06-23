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

@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 
		try {

			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			boolean f = false;

			UserDAO dao = new UserDAO(Connect.getCon());
			User u = new User(name, email, password);
			f = dao.addUser(u);

			HttpSession session = req.getSession();
			if (f) {
				Message msg = new Message("Congrats! Registration successfull...", "alert-success");
				session.setAttribute("msg", msg);
				res.sendRedirect("login_page.jsp");
			} else {
				Message msg = new Message("Oops! Something went wrong...", "alert-danger");
				session.setAttribute("msg", msg);
				res.sendRedirect("signup_page.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
