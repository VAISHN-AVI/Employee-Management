package jspp_employe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateController  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("id"));
		
		EmployeeCRUD crud=new EmployeeCRUD();
		try {
			Employee employee=crud.findEmployee(id);
			
			if(employee !=null)
			{
				// Validating Session 
				HttpSession httpSession = req.getSession();
				String value = (String) httpSession.getAttribute("session");
				if(value !=null) {
					req.setAttribute("emp", employee);
					req.getRequestDispatcher("edit.jsp").forward(req, resp);
				}else
				{
					req.setAttribute("message", "No Session found!! Please Login");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
				
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	long phone=Long.parseLong(req.getParameter("phone"));
	String email=req.getParameter("email");
	String designation=req.getParameter("designation");
	double salary=Double.parseDouble(req.getParameter("salary"));
	String password=req.getParameter("password");

	Employee employee=new Employee();
	employee.setId(id);
	employee.setName(name);
	employee.setPhone(phone);
	employee.setEmail(email);
	employee.setDesignation(designation);
	employee.setSalary(salary);
	employee.setPassword(password);

	EmployeeCRUD crud=new EmployeeCRUD();
	try 
	{
		int result=crud.updateEmployee(employee);
		if(result!=0)
		{
			//using Cookies to Session Tracking
			
			  Cookie[] cookies=req.getCookies(); String value=null; for (Cookie cookie :
			  cookies) {
			  
			  if(cookie.getName().equals("userId")) { value =cookie.getValue(); break;
			  
			  } }
			 
			req.setAttribute("cookie", value);
			req.setAttribute("list", crud.getAllEmployees());
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		}
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}

}
}
