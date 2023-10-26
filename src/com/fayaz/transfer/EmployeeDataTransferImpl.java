package com.fayaz.transfer;

import com.fayaz.dbconnection.IEmployeeDb;
import com.fayaz.dbfactory.DbFactory;
import com.fayaz.employee.Employee;

public class EmployeeDataTransferImpl implements IEmployeeDataTransfer {
	IEmployeeDb  employeeDb=null;
	@Override
	public String insert(String ename, Integer eage, Integer esalary) {
		employeeDb=DbFactory.getEmployeeDb();
		if(employeeDb!=null)
		    return employeeDb.insert(ename,eage,esalary);
		else 
			return "failure";
	}

	@Override
	public Employee select(Integer eid) {
		// TODO Auto-generated method stub
		employeeDb=DbFactory.getEmployeeDb();
		
		    return employeeDb.select(eid);
		
	}

     @Override
	public String delete(Integer eid) {
    	 employeeDb=DbFactory.getEmployeeDb();
    	 return employeeDb.delete(eid);
	}

    @Override
	public String update(Employee employee) {
    	 employeeDb=DbFactory.getEmployeeDb();
		return employeeDb.update(employee);
	}

}
