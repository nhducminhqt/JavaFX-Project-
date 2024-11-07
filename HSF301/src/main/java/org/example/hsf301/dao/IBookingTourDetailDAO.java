package org.example.hsf301.dao;

import org.example.hsf301.pojo.BookingTourDetail;

import java.util.List;

public interface IBookingTourDetailDAO {
    public List<BookingTourDetail> getAll();

    public void save(BookingTourDetail bookingTourDetail);

    public void delete(Long id);

    public BookingTourDetail findById(Long id);

    public void update(BookingTourDetail bookingTourDetail);
}
