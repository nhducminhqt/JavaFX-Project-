package org.example.hsf301.repo;

import org.example.hsf301.pojo.Bookings;

import java.util.List;

public interface IBookingRepo {
    public List<Bookings> getAll();

    public void save(Bookings student);

    public void delete(Long studentID);

    public Bookings findById(Long studentID);

    public void update(Bookings student);
}
