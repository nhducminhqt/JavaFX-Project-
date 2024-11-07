package org.example.hsf301.dao;

import org.example.hsf301.pojo.Bookings;

import java.util.List;

public interface IBookingDAO {
    List<Bookings> findAll();
    void save(Bookings student);
    void delete(Long studentID);
    Bookings findById(Long studentID);
    void update(Bookings student);
    List<Bookings> findByAccountID(String accountID);
}
