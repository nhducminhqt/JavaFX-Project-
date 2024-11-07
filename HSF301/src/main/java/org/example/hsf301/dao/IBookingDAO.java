package org.example.hsf301.dao;

import org.example.hsf301.pojo.Bookings;

import java.util.List;

public interface IBookingDAO {
    List<Bookings> findAll();
    void save(Bookings booking);
    void delete(Long bookingID);
    Bookings findById(Long bookingID);
    void update(Bookings booking);
    List<Bookings> findByAccountID(String accountID);
}
