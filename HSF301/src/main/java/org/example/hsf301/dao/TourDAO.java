package org.example.hsf301.dao;

import java.util.List;
import org.example.hsf301.pojo.Tours;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TourDAO  implements  ITourDAO{

    private SessionFactory sessionFactory = null;
    private Configuration cf = null;

    public TourDAO(String persistanceName) {
        cf = new Configuration();
        cf = cf.configure(persistanceName);
        sessionFactory = cf.buildSessionFactory();
    }

    @Override
    public void save(Tours tours) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(tours);
            t.commit();
            System.out.println("Successfully saved");
        } catch (Exception e) {
            t.rollback();
            System.out.println("Error " + e.getMessage());
            // TODO: handle exception
        } finally {
//			sessionFactory.close();
            session.close();
        }
    }

    @Override
    public List<Tours> findAll() {
        List<Tours> tours = null;
        Session session = sessionFactory.openSession();
        try {
            tours = session.createQuery("from Tours ", Tours.class).list();
        } catch (Exception e) {
            System.out.println("Erorr: " + e.getMessage());
        } finally {
//			sessionFactory.close();
        }
        return tours;
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction t = session.getTransaction();
        try {
            t.begin();
            Tours tour = (Tours) session.get(Tours.class, id);
            session.delete(tour);
            t.commit();
            System.out.println("Successfully Delete");
        } catch (Exception e) {
            t.rollback();
            System.out.println("Error " + e.getMessage());
        } finally {
//			sessionFactory.close();
            session.close();
        }
    }

    @Override
    public Tours findById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            return (Tours) session.get(Tours.class, id);
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
