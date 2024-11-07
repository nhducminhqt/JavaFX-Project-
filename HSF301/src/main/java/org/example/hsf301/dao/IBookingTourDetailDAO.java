package org.example.hsf301.dao;

import org.example.hsf301.pojo.BookingTourDetail;

import java.util.List;

public interface IBookingTourDetailDAO {
    List<BookingTourDetail> getAll();

    void save(BookingTourDetail bookingTourDetail);

    void delete(Long id);

    BookingTourDetail findById(Long id);

    void update(BookingTourDetail bookingTourDetail);
}
