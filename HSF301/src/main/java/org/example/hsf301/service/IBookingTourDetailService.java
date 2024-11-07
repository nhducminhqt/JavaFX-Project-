package org.example.hsf301.service;



import org.example.hsf301.model.request.BookingTourDetailRequest;
import org.example.hsf301.pojo.BookingKoiDetail;
import org.example.hsf301.pojo.BookingTourDetail;

import java.util.List;

public interface IBookingTourDetailService {
    BookingTourDetail addBookingTourDetail(BookingTourDetailRequest bookingTourDetailRequest);

    BookingTourDetail updateBookingTourDetail(Long bookingTourDetailId, BookingTourDetailRequest bookingTourDetailRequest) throws Exception;

    void deleteBookingTourDetail(Long bookingTourDetailId);

    BookingTourDetail getBookingTourDetail(Long bookingTourDetailId);

    List<BookingTourDetail> getAllBookingTourDetails();
    List<BookingTourDetail> bookingTourDetails(Long bookingID);

}
