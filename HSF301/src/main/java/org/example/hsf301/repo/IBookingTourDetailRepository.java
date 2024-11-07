package org.example.hsf301.repo;

import org.example.hsf301.pojo.BookingTourDetail;

import java.util.List;

public interface IBookingTourDetailRepository {
    List<BookingTourDetail> getAll();

    void save(BookingTourDetail bookingTourDetail);

    void delete(Long id);

    BookingTourDetail findById(Long id);

    void update(BookingTourDetail bookingTourDetail);
}
