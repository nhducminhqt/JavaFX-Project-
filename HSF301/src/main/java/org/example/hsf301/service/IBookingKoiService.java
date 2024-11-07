package org.example.hsf301.service;

import org.example.hsf301.enums.PaymentMethod;
import org.example.hsf301.enums.PaymentStatus;
import org.example.hsf301.model.request.BookingKoiRequest;
import org.example.hsf301.model.request.BookingUpdate;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Bookings;

import java.util.List;

public interface IBookingKoiService {
    Bookings createKoiBooking(BookingKoiRequest request, Long bookingTourId, Account account);

    Bookings getKoiBookings(Long bookingId);

    Bookings updateKoiBooking(BookingUpdate update, Long bookingId,Account account);

    List<Bookings> getAllKoiBookings();

    List<Bookings> getAllTourBookings();

    List<Bookings> getAllKoiBookings(String username);

    Bookings deleteKoiBooking(Long bookingId);

    List<Bookings> getAllKoiBookingStatus(PaymentStatus paymentStatus);
}
