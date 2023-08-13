package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

@WebServlet("/doctorUpdate")
public class DoctorUpdate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7964934129810504138L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("full_name");
		String dob = req.getParameter("dob");
		String qualification = req.getParameter("qualification");
		String specialist = req.getParameter("specialist");
		String email = req.getParameter("email");
		String mob_no = req.getParameter("mob_no");
		String password = req.getParameter("password");
		int id = Integer.parseInt(req.getParameter("id"));

		Doctor doctor = new Doctor(id, name, dob, qualification, specialist, email, mob_no, password);
		DoctorDao dao = new DoctorDao(DBConnect.getConn());
		boolean updateDoctor = dao.updateDoctor(doctor);
		HttpSession session = req.getSession();
		if (updateDoctor) {
			session.setAttribute("success", "Doctor update successfully");
			resp.sendRedirect("doctor/profile.jsp");
		} else {
			session.setAttribute("failed", "Something wrong on server");
			resp.sendRedirect("doctor/profile.jsp");
		}
	}

}
