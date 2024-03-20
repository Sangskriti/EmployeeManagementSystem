package com.EmployeeManagementSystem.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EmployeeManagementSystem.entities.Performance;

import java.util.List;

public class PerformanceDaoImpl implements PerformanceDao {
    private final SessionFactory sessionFactory;

    public PerformanceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPerformance(Performance performance) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(performance);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePerformance(Performance performance) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(performance);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePerformance(int performanceID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Performance performance = session.get(Performance.class, performanceID);
            if (performance != null) {
                session.delete(performance);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Performance getPerformanceByID(int performanceID) {
        Performance performance = null;
        try (Session session = sessionFactory.openSession()) {
            performance = session.get(Performance.class, performanceID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return performance;
    }

    @Override
    public List<Performance> getAllPerformances() {
        List<Performance> performances = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Performance> query = session.createQuery("FROM Performance", Performance.class);
            performances = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return performances;
    }
}
