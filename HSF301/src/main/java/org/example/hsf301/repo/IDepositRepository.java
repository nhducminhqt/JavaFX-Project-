package org.example.hsf301.repo;

import org.example.hsf301.pojo.Deposit;

import java.util.List;

public interface IDepositRepository {
    List<Deposit> getAll();

    void save(Deposit student);

    void delete(Long studentID);

    Deposit findById(Long studentID);

    void update(Deposit student);

    Deposit findByBookingId(Long bookingId);
}
