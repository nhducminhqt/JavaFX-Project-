package org.example.hsf301.repo;

import org.example.hsf301.dao.BookingTourDetailDAO;
import org.example.hsf301.dao.IBookingTourDetailDAO;
import org.example.hsf301.pojo.BookingTourDetail;

import java.util.List;

public class BookingTourDetailRepository implements IBookingTourDetailRepository {
    private final IBookingTourDetailDAO bookingTourDetailDAO;

    public BookingTourDetailRepository(String jpaName){
        bookingTourDetailDAO = new BookingTourDetailDAO(jpaName);
    }
    @Override
    public List<BookingTourDetail> getAll() {
        return bookingTourDetailDAO.getAll();
    }

    @Override
    public void save(BookingTourDetail bookingTourDetail) {
        bookingTourDetailDAO.save(bookingTourDetail);
    }

    @Override
    public void delete(Long id) {
    bookingTourDetailDAO.delete(id);
    }

    @Override
    public BookingTourDetail findById(Long id) {
        return bookingTourDetailDAO.findById(id);
    }

    @Override
    public void update(BookingTourDetail bookingTourDetail) {
    bookingTourDetailDAO.update(bookingTourDetail);
    }
}
