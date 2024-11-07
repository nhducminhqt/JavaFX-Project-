package org.example.hsf301.service;

import java.util.List;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.repo.BookingRepository;
import org.example.hsf301.repo.IBookingRepository;

public class BookingService implements IBookingService {
    private final IBookingRepository repository;
    public BookingService(String name) {
        repository = new BookingRepository(name);
    }
    @Override
    public List<Bookings> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Bookings student) {
        repository.save(student);
    }

    @Override
    public void delete(Long studentID) {
        repository.delete(studentID);
    }

    @Override
    public Bookings findById(Long studentID) {
        return repository.findById(studentID);
    }

    @Override
    public void update(Bookings student) {
        repository.update(student);
    }

    @Override
    public List<Bookings> findByAccountID(String accountID) {
        return repository.findByAccountID(accountID);
    }

}
