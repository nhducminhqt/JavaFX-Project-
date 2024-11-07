package org.example.hsf301.service;

import org.example.hsf301.model.request.BookingTourRequest;
import org.example.hsf301.model.request.BookingUpdate;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Bookings;

import java.util.List;

public interface IBookingTourService {
    Bookings createTourBooking(BookingTourRequest request, Account account);

    Bookings getTourBookings(Long bookingId);

    Bookings updateTourBooking(BookingUpdate update, Long bookingId, Account account);

    List<Bookings> getAllTourBookings();

    List<Bookings> getAllTourBookings(String username);

    Bookings deleteTourBooking(Long bookingId);
}
