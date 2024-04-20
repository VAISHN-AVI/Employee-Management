package jspp_employe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password = req.getParameter("password");
		
		EmployeeCRUD crud= new EmployeeCRUD();
		try {
			String dbPassword = crud.getPassword(email);
			RequestDispatcher dispatcher=null;
			if(dbPassword != null)
			{
				if(dbPassword.equals(password)) {
					
					Cookie cookie=new Cookie("userId",email);
					resp.addCookie(cookie);
					
					Cookie cookie1=new Cookie("2","876567890");
					resp.addCookie(cookie1);
					
					Cookie cookie2=new Cookie("3","6666666666");
					resp.addCookie(cookie2);
					
					HttpSession httpSession=req.getSession();
					httpSession.setAttribute("session", dispatcher);
					//remaining code
					
					
					req.setAttribute("list", crud.getAllEmployees());
					dispatcher =req.getRequestDispatcher("success.jsp");
					
				}else {
					req.setAttribute("message", "Invalid Password!!!");
					dispatcher =req.getRequestDispatcher("login.jsp");
				}
			}else {
				req.setAttribute("message", "User not Registered... Please first Register !!!");
				dispatcher =req.getRequestDispatcher("signup.jsp");
			}
			
			dispatcher.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}








