package org.example.hsf301;

import org.example.hsf301.constants.ResourcePaths;
import org.example.hsf301.model.request.BookingKoiDetailRequest;
import org.example.hsf301.model.request.BookingKoiRequest;
import org.example.hsf301.model.request.KoiRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.Koi;
import org.example.hsf301.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class maintest {
    public static void main(String[] args) {
//        IBookingKoiService bookingKoiService = new BookingKoiService(ResourcePaths.HIBERNATE_CONFIG);
//        Bookings booking = new Bookings();
//        IAccountService accountService = new AccountService(ResourcePaths.HIBERNATE_CONFIG);
//
//        // Giả sử bạn đã có một đối tượng Account
//        Account account = accountService.findByUserName("minh1"); // Khởi tạo account theo yêu cầu của bạn.
//
//        // Sử dụng các hàm setter để thiết lập giá trị cho các thuộc tính
//        BookingKoiRequest bookingKoiRequest = new BookingKoiRequest();
//        bookingKoiRequest.setBookingDate(LocalDate.now());
//        bookingKoiRequest.setDiscountAmount(50);
//        bookingKoiRequest.setVat(0.3f);
//        bookingKoiRequest.setPaymentMethod("CASH");
//
//        BookingKoiDetailRequest bookingKoiDetailRequest = new BookingKoiDetailRequest();
//        bookingKoiDetailRequest.setKoiId(1L);
//        bookingKoiDetailRequest.setFarmId(1L);
//        bookingKoiDetailRequest.setQuantity(20);
//        bookingKoiDetailRequest.setUnitPrice(10);
//
//        BookingKoiDetailRequest bookingKoiDetailRequest2 = new BookingKoiDetailRequest();
//        bookingKoiDetailRequest.setKoiId(2L);
//        bookingKoiDetailRequest.setFarmId(1L);
//        bookingKoiDetailRequest.setQuantity(10);
//        bookingKoiDetailRequest.setUnitPrice(5);
//
//        List<BookingKoiDetailRequest> detailRequests = new ArrayList<>();
//        detailRequests.add(bookingKoiDetailRequest);
//        detailRequests.add(bookingKoiDetailRequest2);
//
//        bookingKoiRequest.setDetails(detailRequests);
//
//        bookingKoiService.createKoiBooking(bookingKoiRequest, 3L, account);
        IKoiService koiService = new KoiService(ResourcePaths.HIBERNATE_CONFIG);
        koiService.findById(10002L);

//        KoiRequest koi = new KoiRequest();
//        koi.setImage("test");
//        koi.setKoiName("test");
//        koi.setColor("test");
//        koi.setDescription("test");
//        koi.setOrigin("test");

        System.out.println(koiService.findById(10002L));
    }
}
