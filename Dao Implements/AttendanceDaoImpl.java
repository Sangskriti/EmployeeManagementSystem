package com.EmployeeManagementSystem.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EmployeeManagementSystem.entities.Attendance;

import java.util.List;

public class AttendanceDaoImpl implements AttendanceDao {
    private final SessionFactory sessionFactory;

    public AttendanceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAttendance(Attendance attendance) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(attendance);
            System.out.println("Attendance Update successfull");
            transaction.commit();
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(attendance);
            transaction.commit();
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAttendance(int attendanceID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Attendance attendance = session.get(Attendance.class, attendanceID);
            if (attendance != null) {
                session.delete(attendance);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Attendance getAttendanceByID(int attendanceID) {
        Attendance attendance = null;
        try (Session session = sessionFactory.openSession()) {
            attendance = session.get(Attendance.class, attendanceID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendance;
    }

    @Override
    public List<Attendance> getAllAttendances() {
        List<Attendance> attendances = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Attendance> query = session.createQuery("FROM Attendance", Attendance.class);
            attendances = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendances;
    }
}


