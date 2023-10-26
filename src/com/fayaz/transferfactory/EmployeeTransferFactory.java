package com.fayaz.transferfactory;

import com.fayaz.transfer.EmployeeDataTransferImpl;
import com.fayaz.transfer.IEmployeeDataTransfer;

public class EmployeeTransferFactory {

	//making the constructor private so that for no objection creation..
	private EmployeeTransferFactory() {}
	
	private static IEmployeeDataTransfer employeeDataTransfer=null;
	
	public static  IEmployeeDataTransfer getEmployeeDataTransfer() {
	
       if(employeeDataTransfer==null) {
    	   
		    employeeDataTransfer=new EmployeeDataTransferImpl();
	   }
       
     return employeeDataTransfer;
	}
}
