package com.EmployeeManagementSystem.Dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EmployeeManagementSystem.entities.Department;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    private final SessionFactory sessionFactory;

    public DepartmentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDepartment(Department department) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartment(Department department) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartment(int departmentID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Department department = session.get(Department.class, departmentID);
            if (department != null) {
                session.delete(department);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department getDepartmentByID(int departmentID) {
        Department department = null;
        try (Session session = sessionFactory.openSession()) {
            department = session.get(Department.class, departmentID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Department> query = session.createQuery("FROM Department", Department.class);
            departments = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }
}