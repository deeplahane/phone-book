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
import com.entities.Message;

@WebServlet("/delete")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		ContactDAO dao=new ContactDAO(Connect.getCon());
		boolean v=dao.deleteContact(id);
		
		HttpSession session=req.getSession();

		if(v) {
			Message msg=new Message("Contact Deleted..","alert-success");
			session.setAttribute("msg", msg);
			res.sendRedirect("view_contacts.jsp");
		}else {
			Message msg=new Message("Oops! Something went wrong...","alert-danger");
			session.setAttribute("msg", msg);
			res.sendRedirect("view_contacts.jsp");
		}
		
	}

}
