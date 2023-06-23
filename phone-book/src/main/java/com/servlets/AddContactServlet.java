package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.connector.Connect;
import com.dao.ContactDAO;
import com.entities.Contact;
import com.entities.Message;

@WebServlet("/add_pnumber")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {

			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String pnumber = req.getParameter("pnumber");
			String note = req.getParameter("note");
			int userId = Integer.parseInt(req.getParameter("userId"));
			Contact contact = new Contact(name, email, pnumber, note, userId);

			ContactDAO dao = new ContactDAO(Connect.getCon());
			boolean r = dao.addContact(contact);

			HttpSession session = req.getSession();
			if (r) {
				Message m = new Message("Contact added successfully...", "alert-success");
				session.setAttribute("msg", m);
				res.sendRedirect("add_contact.jsp");
			}else {
				Message m = new Message("Oops! Something went wrong...", "alert-danger");
				session.setAttribute("msg", m);
				res.sendRedirect("add_contact.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
