package com.ngo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.spring.donation.Donor;

/**
 * Servlet implementation class DeleteDonor
 */
public class DeleteDonor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteDonor() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("donor_id"));
			Session s=FactoryProvider.getFactory().openSession();
			Donor d=s.get(Donor.class, id);
			Transaction tx= s.beginTransaction();
			if(d!=null) {
				s.remove(d);
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
