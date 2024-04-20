package jspp_employe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class SignupController extends HttpServlet {

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
		try {
			int result =crud.saveEmployee(employee);
			if(result !=0) {
				req.setAttribute("message","Signup Success,please Login!!!" );
				
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
