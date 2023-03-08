package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import Helper.Helper_class;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login_java extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
		
		String mobileno=req.getParameter("Mobile no");
		String password=req.getParameter("password");
	    String username =Helper_class.authenticateuser(mobileno,password);

	    PrintWriter pw=resp.getWriter();
	    
	    if(username.isEmpty())
	    	pw.print("sucess mr"+username);
	    else
	    	pw.print("fail");
	    	
	
	
	}
}
