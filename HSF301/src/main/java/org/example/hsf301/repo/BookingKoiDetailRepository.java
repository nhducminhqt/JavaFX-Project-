
package org.example.hsf301.repo;

import org.example.hsf301.dao.BookingKoiDetailDAO;
import org.example.hsf301.dao.IBookingKoiDetailDAO;
import org.example.hsf301.pojo.BookingKoiDetail;

import java.util.List;

public class BookingKoiDetailRepository implements IBookingKoiDetailRepository {
    private IBookingKoiDetailDAO dao;
    public BookingKoiDetailRepository(String name) {
        dao = new BookingKoiDetailDAO(name);
    }
    @Override
    public List<BookingKoiDetail> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(BookingKoiDetail student) {
        dao.save(student);
    }

    @Override
    public void delete(Long studentID) {
        dao.delete(studentID);
    }

    @Override
    public List<BookingKoiDetail> findByBookingId(Long bookingId) {
        return dao.findByBookingId(bookingId);
    }

    @Override
    public BookingKoiDetail findById(Long studentID) {
        return dao.findById(studentID);
    }

    @Override
    public void update(BookingKoiDetail student) {
        dao.update(student);
    }
}
