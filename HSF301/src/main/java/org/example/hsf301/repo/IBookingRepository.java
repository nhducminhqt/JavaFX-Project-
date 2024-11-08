package org.example.hsf301.repo;

import org.example.hsf301.enums.PaymentStatus;
import org.example.hsf301.pojo.BookingKoiDetail;
import org.example.hsf301.pojo.Bookings;

import java.util.List;

public interface IBookingRepository {
    List<Bookings> findAll();
    void save(Bookings student);
    void delete(Long studentID);
    Bookings findById(Long studentID);
    void update(Bookings student);
    List<Bookings> findByAccountID(String accountID);
    List<BookingKoiDetail> findByBookingID(Long bookingID);
}
