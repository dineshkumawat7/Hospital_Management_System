package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/changePass")
public class ChangePass extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6549880824402947875L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = Integer.parseInt(req.getParameter("user_id"));
		String pass = req.getParameter("password");
		UserDao dao = new UserDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		User user = new User(uid, pass);
		boolean changePass = dao.changePass(user);
		
		
		if (changePass) {
			session.setAttribute("success", "Successfully Changed User Password");
			resp.sendRedirect("change_pass.jsp");
		} else {
			session.setAttribute("error", "Something wrong on server");
			resp.sendRedirect("change_pass.jsp");
		}
	}

}
