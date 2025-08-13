package com.ngo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.spring.donation.Donor;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class AddDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Transaction beginTransaction;

    public AddDonorServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String donation_type=request.getParameter("type");
			String amount_of_items=request.getParameter("amount");
			Timestamp donated_on=new Timestamp(System.currentTimeMillis());
			Donor d=new Donor(name,email,phone,donation_type,amount_of_items);
			d.setDonated_on(donated_on);
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx= s.beginTransaction();
			s.persist(d);
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<h1 style='text-align:center;'>Donor is added successfully...</h1>");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
