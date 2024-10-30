package org.example.hsf301.repo;

import org.example.hsf301.dao.BookingDAO;
import org.example.hsf301.dao.IBookingDAO;
import org.example.hsf301.pojo.Bookings;

import java.util.List;

public class BookingRepo implements IBookingRepo{
    private IBookingDAO dao;
    public BookingRepo(String name) {
        dao = new BookingDAO(name);
    }
    @Override
    public List<Bookings> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(Bookings student) {
        dao.save(student);
    }

    @Override
    public void delete(Long studentID) {
        dao.delete(studentID);
    }

    @Override
    public Bookings findById(Long studentID) {
        return dao.findById(studentID);
    }

    @Override
    public void update(Bookings student) {
        dao.update(student);
    }
}
