package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.login;
import org.dao.Logindao;


public class loginS extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   
		   request.setCharacterEncoding("utf-8");
		   String name=request.getParameter("uname");
		   String pwd=request.getParameter("upwd");
		   
		   login login=new login(name,pwd);
		  
		 
		  int result=Logindao.login(login);
		   
		  if (result>0) {
				response.sendRedirect("welcome.jsp");
			}
		   else {
			   response.sendRedirect("login.jsp");
		}
		  

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("..."); 
	}

}
