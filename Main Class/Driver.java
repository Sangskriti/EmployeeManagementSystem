package com.EmployeeManagementSystem.Driver;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.EmployeeManagementSystem.Dao.EmployeeDaoImpl;
import com.EmployeeManagementSystem.entities.Department;
import com.EmployeeManagementSystem.entities.Employee;



public class Driver {
    public static void main(String[] args) {
        
            // Initialize Hibernate SessionFactory
        	Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            SessionFactory factory = config.buildSessionFactory();
            
            
          
           EmployeeDaoImpl edi = new  EmployeeDaoImpl(factory);
          Scanner sc = new Scanner(System.in);
          
          boolean exit = false;
          while(exit==false)
          {
              
        	  System.out.println("1: Add employee");
        	  System.out.println("2: Update Employee Name");
        	  System.out.println("3: Delete Employee");
        	  System.out.println("4: Enter Employee ID to get Employee Details");
        	  System.out.println("5: Get All Employee Details");
              System.out.println("6: Exit");
              
        	  System.out.println("Enter your Choice ");
        	  
        	  int choice = sc.nextInt();
        	  switch(choice)
        	  {
        	  case 1: 
        		  Scanner sc1 = new Scanner(System.in);
        		  Employee employee = new Employee();
        		  System.out.println("Enter First name ");
        		  String name = sc1.nextLine();
        		  System.out.println("Enter Last name ");
        		  String Lname = sc1.nextLine();
        		  System.out.println("Enter Email  ");
        		  String email = sc1.nextLine();
        		  System.out.println("Enter Mobile number Number ");
        		  long mobile = sc.nextLong();
        		  sc.nextLine();
        		  employee.setContactNumber(mobile);
        		  employee.setFirstName(name);
        		  employee.setLastName(Lname);
        		  employee.setEmail(email);
        		  edi.addEmployee(employee);
        		  break;
        		  
        	  case 2:
        		  Scanner sc2 = new Scanner(System.in);
        		  System.out.println("Enter Employee Id");
        		  int eid = sc2.nextInt();
        		  sc2.nextLine();
        		  System.out.println("Enter Employee Name ");
        		  String  First_Name = sc2.nextLine();
        		  System.out.println("Enter Last Name ");
        		  String lastname = sc2.nextLine();
        		  edi.updateEmployeeName(eid, First_Name,lastname);
        		  break;
        		  
        	  case 3:
        		  Scanner sc3 = new Scanner(System.in);
        		  System.out.println("Enter Employee Id");
        		  int emid = sc3.nextInt();
        		  edi.deleteEmployee(emid);
        		  break;
        		  
        	  case 4:
        		  Scanner sc4 = new Scanner(System.in);
        		  System.out.println("Enter Employee Id");
        		  int em = sc4.nextInt();
        		  edi.getEmployeeByID(em);
        		  break;
        	  case 5:
        		  edi.getAllEmployees();
        		  break;
        	  case 6:
        		  System.out.println("Exit sucessfull");
        		  exit=true;
        		  break;
        		  
        	  
        		  
        	  }
        	  
        	  
          }
          

            //factory.close();
            
            
            //session.close();
      }
    }
