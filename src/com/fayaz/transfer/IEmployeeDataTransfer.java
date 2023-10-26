package com.fayaz.transfer;

import com.fayaz.employee.Employee;

public interface IEmployeeDataTransfer {
	
	public String insert(String ename,Integer eage,Integer esalary);
	public Employee select(Integer eid);
	public String delete(Integer eid);
	public String update(Employee employee);
}
