package com.EmployeeManagementSystem.Dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

import com.EmployeeManagementSystem.entities.Salary;

public class SalaryDaoImpl implements SalaryDao {
    private final SessionFactory sessionFactory;

    public SalaryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSalary(Salary salary) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(salary);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSalary(Salary salary) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(salary);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSalary(int salaryID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Salary salary = session.get(Salary.class, salaryID);
            if (salary != null) {
                session.delete(salary);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Salary getSalaryByID(int salaryID) {
        Salary salary = null;
        try (Session session = sessionFactory.openSession()) {
            salary = session.get(Salary.class, salaryID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salary;
    }

    @Override
    public List<Salary> getAllSalaries() {
        List<Salary> salaries = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Salary> query = session.createQuery("FROM Salary", Salary.class);
            salaries = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salaries;
    }
}
