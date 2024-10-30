package org.example.hsf301.dao;

import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.DeliveryHistory;
import org.example.hsf301.pojo.Deposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DepositDAO implements IDepositDAO{
    private SessionFactory sessionFactory;
    private Configuration configuration;


    public DepositDAO(String name) {
        configuration = new Configuration();
        configuration = configuration.configure(name);
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public List<Deposit> getAll() {
        List<Deposit> students = null;
        Session session = sessionFactory.openSession();
        try {
            students = session.createQuery("from Deposit", Deposit.class).list();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error" + e.getMessage());
        } finally {
            //sessionFactory.close();
            session.close();
        }
        return students;
    }

    @Override
    public void save(Deposit student) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(student);
            t.commit();
            System.out.println("Successfully saved");
        } catch (Exception e) {
            // TODO: handle exception
            t.rollback();
            System.out.println("Error" + e.getMessage());
        } finally {
            //	sessionFactory.close();
            session.close();
        }
    }

    @Override
    public void delete(Long studentID) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Deposit student = (Deposit) session.get(Deposit.class,studentID);
            session.delete(student);
            t.commit();
            System.out.println("Delete saved");
        } catch (Exception e) {
            // TODO: handle exception
            t.rollback();
            throw e;
        } finally {
//			sessionFactory.close();
            session.close();
        }
    }

    @Override
    public Deposit findById(Long studentID) {
        Session session = sessionFactory.openSession();
        try {
            return (Deposit) session.get(Deposit.class,studentID);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Deposit student) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(student);
            t.commit();
            System.out.println("Update successfully");
        } catch (Exception e) {
            // TODO: handle exception
            t.rollback();
            System.out.println("Error "+e.getMessage());
        } finally {
            //sessionFactory.close();
            session.close();
        }
    }

    @Override
    public Deposit findByBookingId(Long bookingId) {
        Deposit deposit = new Deposit();
        Session session = sessionFactory.openSession();
        Transaction t =null;
        try {
             t = session.beginTransaction();
            Query<Deposit> query = session.createQuery("FROM deposit d WHERE d.booking.id = :bookingId", Deposit.class);
            query.setParameter("bookingId", bookingId);
            deposit = query.uniqueResult();
            t.commit();
        } catch (Exception e) {
        if (t != null) t.rollback();
        e.printStackTrace();
    }
        return deposit;
    }
}
