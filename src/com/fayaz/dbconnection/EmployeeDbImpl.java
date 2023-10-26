package com.fayaz.dbconnection;
import java.io.IOException;
import java.sql.*;
import com.fayaz.employee.Employee;

public class EmployeeDbImpl implements IEmployeeDb {
    Connection connection=null;
    PreparedStatement pstmnt=null;
    ResultSet resultSet=null;
    String url="jdbc:mysql://localhost:3306/mydb";
    String username="root";
    String password="Fayaz@3";
	@Override
	public String insert(String ename, Integer eage, Integer esalary) {
		String sqlInsertQuery="insert into employee (ename,eage,esalary)values(?,?,?)";
		
		try {
			connection=DriverManager.getConnection(url,username,password);
			
			if(connection!=null)
				pstmnt=connection.prepareStatement(sqlInsertQuery);
			
			if(pstmnt!=null) {
				 pstmnt.setString(1, ename);
			     pstmnt.setInt(2, eage);
			     pstmnt.setInt(3, esalary);
			     
		    int rowAffected=pstmnt.executeUpdate();
		    if(rowAffected==1) {
		    	return "success";
		    }
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Employee select(Integer eid) {
String sqlSelectQuery="select eid,ename,eage,esalary from employee where eid=?";
Employee employee=null;
		try {
			connection=DriverManager.getConnection(url,username,password);
			if(connection!=null)
				pstmnt=connection.prepareStatement(sqlSelectQuery);
			if(pstmnt!=null) {
				 pstmnt.setInt(1, eid);
			}
			if(pstmnt!=null) {
				resultSet=pstmnt.executeQuery();
			}
			if(resultSet!=null) {
				
				if(resultSet.next()) {
					employee=new Employee();
					employee.setEid(resultSet.getInt(1));
					employee.setEname(resultSet.getString(2));
					employee.setEage(resultSet.getInt(3));
					employee.setEsalary(resultSet.getInt(4));
					return employee;
				}
			}
		   
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(Integer eid) {
String sqlDeleteQuery="delete from employee where eid=?";
		
		try {
			connection=DriverManager.getConnection(url,username,password);
			if(connection!=null)
				pstmnt=connection.prepareStatement(sqlDeleteQuery);
			if(pstmnt!=null) {
			     pstmnt.setInt(1, eid);
			}
			     
		    int rowAffected=pstmnt.executeUpdate();
		    if(rowAffected==1) {
		    	return "success";
		    }else {
		    	return "not found";
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return "failure";
	}

	@Override
	public String update(Employee employee) {
String sqlUpdateQuery="update employee set ename=?,eage=?,esalary=? where eid=? ";
		
		try {
			connection=DriverManager.getConnection(url,username,password);
			if(connection!=null)
				pstmnt=connection.prepareStatement(sqlUpdateQuery);
			if(pstmnt!=null) {
				 pstmnt.setString(1, employee.getEname());
			     pstmnt.setInt(2,employee.getEage());
			     pstmnt.setInt(3, employee.getEsalary());
			     pstmnt.setInt(4, employee.getEid());
		    int rowAffected=pstmnt.executeUpdate();
		    if(rowAffected==1) {
		    	return "success";
		    }
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

}
