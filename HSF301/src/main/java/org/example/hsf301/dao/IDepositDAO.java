package org.example.hsf301.dao;

import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.DeliveryHistory;
import org.example.hsf301.pojo.Deposit;

import java.util.List;

public interface IDepositDAO {
    List<Deposit> getAll();

    void save(Deposit student);

    void delete(Long studentID);

    Deposit findById(Long studentID);

    void update(Deposit student);

    Deposit findByBookingId(Long bookingId);
}
