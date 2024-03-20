package com.EmployeeManagementSystem.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

import com.EmployeeManagementSystem.entities.Position;

public class PositionDaoImpl implements PositionDao {
    private final SessionFactory sessionFactory;

    public PositionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPosition(Position position) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(position);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePosition(Position position) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(position);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePosition(int positionID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Position position = session.get(Position.class, positionID);
            if (position != null) {
                session.delete(position);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Position getPositionByID(int positionID) {
        Position position = null;
        try (Session session = sessionFactory.openSession()) {
            position = session.get(Position.class, positionID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return position;
    }

    @Override
    public List<Position> getAllPositions() {
        List<Position> positions = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Position> query = session.createQuery("FROM Position", Position.class);
            positions = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }
}
