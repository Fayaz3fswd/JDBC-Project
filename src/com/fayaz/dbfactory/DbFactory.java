package com.fayaz.dbfactory;

import com.fayaz.dbconnection.EmployeeDbImpl;
import com.fayaz.dbconnection.IEmployeeDb;

public class DbFactory {
	
   private DbFactory(){}
   
   private static IEmployeeDb employeeDb=null;
   
   public static IEmployeeDb getEmployeeDb() {
	   
	   if(employeeDb==null) {
		   
		   employeeDb=new EmployeeDbImpl();
	   }
	   
	   return employeeDb;
   }
}
