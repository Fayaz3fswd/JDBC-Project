package com.fayaz.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.util.Scanner;

import com.fayaz.employee.Employee;
import com.fayaz.transfer.IEmployeeDataTransfer;
import com.fayaz.transferfactory.EmployeeTransferFactory;

public class CrudApp {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("1.Insert");
			System.out.println("2.Select");
			System.out.println("3.Delete");
			System.out.println("4.Update");
			System.out.println("5. Exit");
			System.out.println("enter ur choice :: ");
			int ch=scan.nextInt();
			switch(ch) {
			case 1:
				insertionOperation();
				break;
            case 2:
				selectionOperation();
				break;
            case 3:
	             deleteOperation();
	            break;
           case 4:
	             updateOperation();
	            break;
           case 5:System.out.println("Exiting the application...");
	           System.exit(0);
             	break;
		    default:System.out.println("Try with values 0-5");
				break;
			}
		}
	}
	private static void updateOperation() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the eid to be updated");
		String eid=br.readLine();
		IEmployeeDataTransfer employeeDataTransfer=EmployeeTransferFactory.getEmployeeDataTransfer();
		Employee employee=employeeDataTransfer.select(Integer.parseInt(eid));
		if(employee!=null) {
			Employee updateStudent=new Employee();
			System.out.println("Employee id ::"+employee.getEid());
			updateStudent.setEid(employee.getEid());
			System.out.println("Employee name before updation::"+employee.getEname()+" Enter the Employee name to be updated ::");
			String EUpdatedName=br.readLine();
			if(EUpdatedName.equals("")|| EUpdatedName=="") {
				updateStudent.setEname(employee.getEname());
			}else {
				updateStudent.setEname(EUpdatedName);
			}
			System.out.println("Employee age before updation::"+employee.getEage()+" Enter the Employee age to be updated ::");
			String EUpdatedAge=br.readLine();
			
			if(EUpdatedAge.equals("")|| EUpdatedAge=="") {
				updateStudent.setEage(employee.getEage());
			}else {
				updateStudent.setEage(Integer.parseInt(EUpdatedAge));
			}
			System.out.println("Employee salary before updation::"+employee.getEsalary()+" Enter the Employee salary to be update ::");
			String EUpdatedSalary=br.readLine();
			
			if(EUpdatedSalary.equals("")|| EUpdatedSalary=="") {
				updateStudent.setEsalary(employee.getEsalary());
			}else {
				updateStudent.setEsalary(Integer.parseInt(EUpdatedSalary));
			}
			
			String msg=employeeDataTransfer.update(updateStudent);
			
			if(msg.equalsIgnoreCase("success")) {
				System.out.println("Data updation done");
			}
			else {
				System.out.println("Data updation failed");
			}
			
		}
		else {
			System.out.println("Emplyee Data is not available for id "+eid);
		}
	}
	
	
	private static void deleteOperation() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the eid for deletion");
		int eid=sc.nextInt();
		IEmployeeDataTransfer employeeDataTransfer=EmployeeTransferFactory.getEmployeeDataTransfer();
		String msg=employeeDataTransfer.delete(eid);
		
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Data deletion done");
		}else if (msg.equalsIgnoreCase("not found")) {
			System.out.println("Data is not available for id "+eid);
		}
		else {
			System.out.println("Data deletion failed");
		}
		
	}
	
	private static void selectionOperation() {
	 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the eid");
		int eid=sc.nextInt();
		IEmployeeDataTransfer employeeDataTransfer=EmployeeTransferFactory.getEmployeeDataTransfer();
		Employee emp=employeeDataTransfer.select(eid);
		if(emp!=null) {
			
			System.out.println("eid \t ename \t eage \t esalary");
			System.out.println(emp.getEid()+"\t"+emp.getEname()+"\t"+emp.getEage()+"\t"+emp.getEsalary());
		}else {
			System.out.println("No data for the entered id "+ eid);
		}
		
		
		
	}

	private static void insertionOperation() {
		
		IEmployeeDataTransfer employeeDataTransfer=EmployeeTransferFactory.getEmployeeDataTransfer();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the ename");
		String ename=sc.next();
		
		System.out.println("Enter the eage");
		int eage=sc.nextInt();
		
		System.out.println("Enter the esalary");
		int esalary=sc.nextInt();
		
		String msg=employeeDataTransfer.insert(ename, eage, esalary);
		if(msg.equals("success")) {
			System.out.println("Data insertion done");
		}else {
			System.out.println("Data insertion failed");
		}
		
		}
}
