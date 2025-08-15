package com.ngo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.spring.donation.Donor;

/**
 * Servlet implementation class UpdateDonor
 */
public class UpdateDonor extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateDonor() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String donation_type=request.getParameter("type");
			String amount_of_items=request.getParameter("amount");
			Timestamp donated_on=new Timestamp(System.currentTimeMillis());
			Session s=FactoryProvider.getFactory().openSession();
			Donor d=s.get(Donor.class, id);
					d.setDonated_on(donated_on);
			Transaction tx= s.beginTransaction();
			if(d!=null) {
				d.setEmail(email);
				d.setName(name);
				d.setPhone(phone);
				d.setAmount_of_items(amount_of_items);
				d.setDonation_type(donation_type);
				
			}
			tx.commit();
			s.close();
			response.sendRedirect("viewDonor.jsp");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
