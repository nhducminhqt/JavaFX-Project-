package org.example.hsf301.service;

import org.example.hsf301.model.request.BookingKoiDetailRequest;
import org.example.hsf301.pojo.BookingKoiDetail;
import org.example.hsf301.repo.IBookingKoiDetailRepository;

import java.util.List;

public class BookingKoiDetailService implements IBookingKoiDetailService{
    private IBookingKoiDetailRepository bookingKoiDetailRepo;

    @Override
    public BookingKoiDetail createKoiDetail(BookingKoiDetailRequest bookingKoiDetailRequest, Long bookingId) {
        return null;
    }

    @Override
    public void deletebyBookingKoiDetail(Long bookingKoiDetailId) {

    }

    @Override
    public List<BookingKoiDetail> bookingKoiDetails(Long bookingID) {
        return List.of();
    }

    @Override
    public List<BookingKoiDetail> updateBookingKoiDetail(Long id, BookingKoiDetailRequest BookingKoiDetailRequest) {
        return List.of();
    }
}
