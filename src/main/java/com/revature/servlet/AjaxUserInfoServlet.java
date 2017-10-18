package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.UserTable;
import com.revature.service.UserService;

/**
 * Servlet implementation class AjaxUserInfoServlet
 */

@WebServlet("/ajaxUserInfo")
public class AjaxUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxUserServlet - GET");
		
		//Client wants the BankUser Object that at this point should be stored in the session
		HttpSession session = request.getSession();
		UserTable clientUser = (UserTable) session.getAttribute("user");
		
		//basic null check
		if(clientUser != null) {
				
				System.out.println("---------------JSON Mapping------------------");
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(clientUser);
				
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.write(json);
				
			
		}

		
	}

}
