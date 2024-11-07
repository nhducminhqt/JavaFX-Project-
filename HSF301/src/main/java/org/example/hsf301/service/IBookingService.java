package org.example.hsf301.service;

import java.util.List;
import org.example.hsf301.enums.PaymentStatus;
import org.example.hsf301.pojo.BookingKoiDetail;
import org.example.hsf301.pojo.Bookings;

public interface IBookingService {
    List<Bookings> findAll();
    void save(Bookings student);
    void delete(Long studentID);
    Bookings findById(Long studentID);
    void update(Bookings student);
    List<Bookings> findByAccountID(String accountID);
    List<BookingKoiDetail> findByBookingID(Long bookingID);
    void updateBookingStatus(Long bookingID, PaymentStatus status);
}
