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
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegisterServlet -GET");
		request.getRequestDispatcher("register.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegisterServlet -POST");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		System.out.println("The user entered: " + firstName + " " + lastName + " " + username + " " + password + " " + email);
		
		UserTable clientUser = new UserTable(firstName, lastName, username, password, email);
		//create student
		new UserService().newUser(clientUser);
		clientUser = new UserService().validateUser(clientUser);
		
		if(clientUser != null) {
			//Store the valid user into the Session
			HttpSession session = request.getSession();
			session.setAttribute("user", clientUser);
			
			//validated student sent to homepage
			request.getRequestDispatcher("student.html").forward(request, response);
			
		}else {
			doGet(request, response);
		}
	}

}
