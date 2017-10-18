package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.UserTable;
import com.revature.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet -GET");
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet -POST");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("The user entered: " + username + " " + password);
		
		UserTable clientUser = new UserTable(username, password);
		clientUser = new UserService().validateUser(clientUser);
		
		if(clientUser != null) {
			//Store the valid user into the Session
			HttpSession session = request.getSession();
			session.setAttribute("user", clientUser);
			
			//validated user sent to homepage
			if(clientUser.getUr_id() == 1) {
			request.getRequestDispatcher("student.html").forward(request, response);
			}else {
				request.getRequestDispatcher("teacher.html").forward(request, response);
			}
		}else {
			doGet(request, response);
		}

	}

}
