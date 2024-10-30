package org.example.hsf301.dao;

import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.Delivery;

import java.util.List;

public interface IBookingDAO {
    public List<Bookings> getAll();

    public void save(Bookings student);

    public void delete(Long studentID);

    public Bookings findById(Long studentID);

    public void update(Bookings student);
}
