package org.example.hsf301.dao;

import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.DeliveryHistory;
import org.example.hsf301.pojo.Deposit;

import java.util.List;

public interface IDepositDAO {
    public List<Deposit> getAll();

    public void save(Deposit student);

    public void delete(Long studentID);

    public Deposit findById(Long studentID);

    public void update(Deposit student);

    public Deposit findByBookingId(Long bookingId);
}
