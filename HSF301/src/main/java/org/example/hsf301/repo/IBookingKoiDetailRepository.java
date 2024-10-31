package org.example.hsf301.repo;

import org.example.hsf301.pojo.BookingKoiDetail;

import java.util.List;

public interface IBookingKoiDetailRepository {
    public List<BookingKoiDetail> getAll();

    public void save(BookingKoiDetail student);

    public void delete(Long studentID);

    public BookingKoiDetail findById(Long studentID);

    public void update(BookingKoiDetail student);
}
