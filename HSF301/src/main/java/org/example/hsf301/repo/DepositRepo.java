package org.example.hsf301.repo;

import org.example.hsf301.dao.DepositDAO;
import org.example.hsf301.dao.IDepositDAO;
import org.example.hsf301.pojo.Deposit;

import java.util.List;

public class DepositRepo implements IDepositRepo{
    private IDepositDAO dao;
    public DepositRepo(String name) {
        dao = new DepositDAO(name);
    }

    @Override
    public List<Deposit> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(Deposit student) {
       dao.save(student);
    }

    @Override
    public void delete(Long studentID) {
        dao.delete(studentID);
    }

    @Override
    public Deposit findById(Long studentID) {
        return dao.findById(studentID);
    }

    @Override
    public void update(Deposit student) {
        dao.update(student);
    }

    @Override
    public Deposit findByBookingId(Long bookingId) {
        return dao.findByBookingId(bookingId);
    }
}
