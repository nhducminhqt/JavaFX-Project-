package org.example.hsf301.repo;

import org.example.hsf301.pojo.BookingKoiDetail;

import java.util.List;

public interface IBookingKoiDetailRepository {
    List<BookingKoiDetail> getAll();

    void save(BookingKoiDetail student);

    void delete(Long studentID);

    List<BookingKoiDetail> findByBookingId(Long bookingId);

    BookingKoiDetail findById(Long studentID);

    void update(BookingKoiDetail student);
}
