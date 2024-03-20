package com.EmployeeManagementSystem.Dao;

import com.EmployeeManagementSystem.entities.Department;
import com.EmployeeManagementSystem.entities.Employee;
import com.EmployeeManagementSystem.entities.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private final SessionFactory sessionFactory;

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            System.out.println("Employee add successfull");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Override
    public  void updateEmployeeName(int eid,String  firstName, String lastName ) {
    	
    	
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();  
            Query<Employee> query = session.createQuery("update Employee set  firstName =:fname, lastName =:lastName where Employee_ID =:eid");
            query.setParameter("eid", eid);
            query.setParameter("fname", firstName);
            query.setParameter("lastName", lastName);
           
           
           int count = query.executeUpdate();
            transaction.commit();
            
            if(count >0) {
            System.out.println("Name Update Success");
            }
            else
            {
            	System.out.println("No update success");
            }
            
        } 

    @Override
    public void deleteEmployee(int employeeID) {
        
    	Session session = sessionFactory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	Query <Employee> query = session.createQuery("delete from Employee where Employee_ID = :employeeID");
    	query.setParameter("employeeID", employeeID);
    	int count =query.executeUpdate();
    	transaction.commit();
    	if(count!=0)
    	{
    		System.out.println("Employee delete success");
    	}
    	else
    	{
    		System.out.println("Employee delete Unsuccessfull");
    	}
    	
    }

    @Override
    public void getEmployeeByID(int employeeID) {
    	Session session = sessionFactory.openSession();
    	Employee emp = new Employee();
    	Query query = session.createQuery("from Employee where Employee_ID=:employeeID");
    	query.setParameter("employeeID", employeeID);
    	Employee employee = (Employee)query.uniqueResult();
    	
    	if(employee!= null)
    	{
    		
    		//System.out.println(employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getContactNumber());
    		System.out.format("%-5s  %-20s  %-30s  %-20s  %-30s\n" ,"Id "," First_Name ", "Last_Name" ,"Contact_Number","Email");
			System.out.format("%-5s  %-20s  %-30s  %-20s  %-30s\n" ,employee.getEmployeeID(),employee.getFirstName(),employee.getLastName(),employee.getContactNumber(),employee.getEmail());
    		
    	}
    	else
    	{
    		System.out.println("No employee found by this Id");
    	}
    	
    	
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
            employees = query.list();
            if(employees!=null)
            {
            	System.out.format("%-5s  %-20s  %-30s  %-20s  %-30s\n" ,"Id "," First_Name ", "Last_Name" ,"Contact_Number","Email");
            	for(Employee em :employees)
            	{
            		System.out.format("%-5s  %-20s  %-30s  %-20s  %-30s\n" ,em.getEmployeeID(),em.getFirstName(),em.getLastName(),em.getContactNumber(),em.getEmail());
            		
            	}
            }
            else 
            {
            	System.out.println("No candidate Availebe ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    
    
    
    
}
