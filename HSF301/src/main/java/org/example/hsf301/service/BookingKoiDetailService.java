package org.example.hsf301.service;

import org.example.hsf301.model.request.BookingKoiDetailRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.BookingKoiDetail;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.Koi;
import org.example.hsf301.repo.*;

import java.util.List;

public class BookingKoiDetailService implements IBookingKoiDetailService{
    private IBookingKoiDetailRepository bookingKoiDetailRepo;
    private IKoiRepository koiRepository;
    private IBookingRepository bookingRepository;
    private Account account;
    public BookingKoiDetailService(String name, Account account) {
        bookingKoiDetailRepo = new BookingKoiDetailRepository(name);
        koiRepository = new KoiRepository(name);
        bookingRepository = new BookingRepository(name);
        this.account = account;
    }
    @Override
    public BookingKoiDetail createKoiDetail(BookingKoiDetailRequest bookingKoiDetailRequest, Long bookingId) {
        Bookings bookings = bookingRepository.findById(bookingId);
        if(bookings == null) {
            throw new IllegalArgumentException("BookingKoiDetail with id " + bookingId + " not found");
        }
        Koi koi = koiRepository.findById(bookingKoiDetailRequest.getKoiId());
        if(koi == null) {
            throw new IllegalArgumentException("Koi " + bookingKoiDetailRequest.getKoiId() + " not found");
        }
        BookingKoiDetail bookingKoiDetail = new BookingKoiDetail();
        bookingKoiDetail.setBooking(bookings);
        bookingKoiDetail.setKoi(koi);
        bookingKoiDetail.setQuantity(bookingKoiDetailRequest.getQuantity());
        bookingKoiDetail.setUnitPrice(bookingKoiDetailRequest.getUnitPrice());
        bookingKoiDetail.setTotalAmount(bookingKoiDetailRequest.getUnitPrice() * bookingKoiDetailRequest.getQuantity());
        bookingKoiDetailRepo.save(bookingKoiDetail);

        float totalBookingAmount = bookingKoiDetail.getTotalAmount();
        totalBookingAmount += bookingKoiDetail.getTotalAmount();
        bookings.setTotalAmount(totalBookingAmount);
        bookings.setTotalAmountWithVAT(bookings.getTotalAmount() + bookings.getVatAmount() - bookings.getDiscountAmount());
        bookingRepository.save(bookings);

        return bookingKoiDetail;
    }

    @Override
    public void deletebyBookingKoiDetail(Long bookingKoiDetailId) {
        BookingKoiDetail bookingKoiDetail = bookingKoiDetailRepo.findById(bookingKoiDetailId);
        if(bookingKoiDetail == null) {
            throw new IllegalArgumentException("BookingKoiDetail with id " + bookingKoiDetailId + " not found");
        }
        Bookings bookings = bookingKoiDetail.getBooking();
        float totalBookingAmount = bookingKoiDetail.getTotalAmount();
        totalBookingAmount -= bookingKoiDetail.getTotalAmount();
        bookings.setTotalAmount(totalBookingAmount);
        bookings.setVatAmount(bookings.getVat()*(bookings.getTotalAmount()- bookings.getDiscountAmount()));
        bookings.setTotalAmountWithVAT(bookings.getTotalAmount() + bookings.getVatAmount() - bookings.getDiscountAmount());
        bookings.setUpdatedBy(account);

        bookingKoiDetailRepo.delete(bookingKoiDetailId);
        bookingRepository.save(bookings);

    }

    @Override
    public List<BookingKoiDetail> bookingKoiDetails(Long bookingID) {
        return bookingKoiDetailRepo.findByBookingId(bookingID);
    }

    @Override
    public BookingKoiDetail updateBookingKoiDetail(Long id, BookingKoiDetailRequest bookingKoiDetailRequest) {
        Koi koi = koiRepository.findById(bookingKoiDetailRequest.getKoiId());
        if(koi == null) {
            throw new IllegalArgumentException("Koi " + bookingKoiDetailRequest.getKoiId() + " not found");
        }
        BookingKoiDetail bookingKoiDetail = bookingKoiDetailRepo.findById(id);
        if(bookingKoiDetail == null) {
            throw new IllegalArgumentException("BookingKoiDetail with id " + id + " not found");
        }
        Bookings bookings = bookingKoiDetail.getBooking();
        float totalBookingAmount = bookings.getTotalAmount();
        totalBookingAmount -= bookingKoiDetail.getTotalAmount();

        bookingKoiDetail.setKoi(koi);
        bookingKoiDetail.setQuantity(bookingKoiDetailRequest.getQuantity());
        bookingKoiDetail.setUnitPrice(bookingKoiDetailRequest.getUnitPrice());
        bookingKoiDetail.setTotalAmount(bookingKoiDetailRequest.getUnitPrice() * bookingKoiDetailRequest.getQuantity());
        bookingKoiDetailRepo.update(bookingKoiDetail);

        totalBookingAmount += bookingKoiDetail.getTotalAmount();
        bookings.setTotalAmount(totalBookingAmount);
        bookings.setVatAmount(bookings.getVat()*(bookings.getTotalAmount()- bookings.getDiscountAmount()));
        bookings.setTotalAmountWithVAT(bookings.getTotalAmount() + bookings.getVatAmount() - bookings.getDiscountAmount());
        bookings.setUpdatedBy(account);
        bookingRepository.update(bookings);


        return bookingKoiDetail;
    }
}
