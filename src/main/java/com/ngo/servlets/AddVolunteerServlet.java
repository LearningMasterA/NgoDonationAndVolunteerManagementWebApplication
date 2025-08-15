package com.ngo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.spring.donation.Volunteer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddVolunteerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddVolunteerServlet() {
        super();
    }
//    private String name;
//	private String email;
//	private String phone;
//	private String skills;
//	private String availability;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String skills=request.getParameter("skills");
			String availability=request.getParameter("availability");
			Volunteer v=new Volunteer(name,email,phone,skills,availability);
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			s.persist(v);
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<h1 style='text-align:center;'>Volunteer is added successfully...</h1>");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
