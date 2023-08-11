package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8700422853999268015L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			int did = Integer.parseInt(req.getParameter("did"));
			String comment = req.getParameter("comment");
			AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
			boolean updateCommentStatus = dao.updateCommentStatus(id, did, comment);
			HttpSession session = req.getSession();
			if (updateCommentStatus) {
				session.setAttribute("success", "Comment Updated");
				resp.sendRedirect("doctor/patient.jsp");
			} else {
				session.setAttribute("error", "Something wrong on server");
				resp.sendRedirect("doctor/patient.jsp");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
