package jspp_employe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","Sagar@2922");
		
	}
	
	public int saveEmployee(Employee employee) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
		
		preparedStatement.setInt(1,employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3,employee.getPhone());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getDesignation());
		preparedStatement.setDouble(6, employee.getSalary());
		preparedStatement.setString(7, employee.getPassword());
		int count = preparedStatement.executeUpdate();
		connection.close();
		
		return count;
		
	}
	
	public String getPassword(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select password from employee where email=?");
		preparedStatement.setString(1, email);
		ResultSet set= preparedStatement.executeQuery();
		String password=null;
		while(set.next())
		{
			password= set.getString("password");
		}
		connection.close();
		return password;
		
	}
	
	public List<Employee> getAllEmployees() throws Exception
	{
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from employee");
		ResultSet set= preparedStatement.executeQuery();
		List<Employee> list=new ArrayList<>();
		while(set.next())
		{
			Employee employee=new Employee();
			employee.setId(set.getInt("id"));
			employee.setName(set.getString("name"));
			employee.setPhone(set.getLong("phone"));
			employee.setEmail(set.getString("email"));
			employee.setDesignation(set.getString("designation"));
			employee.setSalary(set.getDouble("salary"));
			employee.setPassword(set.getString("password"));
		
			list.add(employee);
		
		}
		connection.close();
		
		return list;
		
	}
	
	public int deleteEmployee(int id) throws Exception{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from employee where id=?");
		preparedStatement.setInt(1, id);
		int count= preparedStatement.executeUpdate();
		connection.close();
		return count;
		
	}
	
	public Employee findEmployee(int id) throws Exception{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from employee where id=?");
		preparedStatement.setInt(1, id);
		ResultSet set= preparedStatement.executeQuery();
		Employee employee=new Employee();
		
		while(set.next())
		{
			employee.setId(set.getInt("id"));
			employee.setName(set.getString("name"));
			employee.setPhone(set.getLong("phone"));
			employee.setEmail(set.getString("email"));
			employee.setDesignation(set.getString("designation"));
			employee.setSalary(set.getDouble("salary"));
			employee.setPassword(set.getString("password"));
			
			
		}
		connection.close();
		return employee;
	}
	
	public int updateEmployee(Employee employee) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update employee set name=?,phone=?,email=?,designation=?,salary=?,password=?");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getDesignation());
		preparedStatement.setDouble(6, employee.getSalary());
		preparedStatement.setString(7, employee.getPassword());
		
		int count=preparedStatement.executeUpdate();
		connection.close();
		return count;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
