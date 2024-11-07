package org.example.hsf301.service;

import org.example.hsf301.model.request.BookingKoiDetailRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.BookingKoiDetail;

import java.util.List;

public interface IBookingKoiDetailService {
    BookingKoiDetail createKoiDetail(BookingKoiDetailRequest bookingKoiDetailRequest, Long bookingId);

    void deletebyBookingKoiDetail(Long bookingKoiDetailId, Account staff);

    List<BookingKoiDetail> bookingKoiDetails(Long bookingID);

    BookingKoiDetail updateBookingKoiDetail(Long id, BookingKoiDetailRequest BookingKoiDetailRequest,Account staff);
}
