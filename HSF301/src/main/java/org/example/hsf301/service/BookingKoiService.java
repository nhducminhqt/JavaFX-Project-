package org.example.hsf301.service;

import org.example.hsf301.model.request.BookingKoiDetailRequest;
import org.example.hsf301.model.request.BookingKoiRequest;
import org.example.hsf301.model.request.BookingUpdate;
import org.example.hsf301.pojo.*;
import org.example.hsf301.repo.*;

import java.util.ArrayList;
import java.util.List;

public class BookingKoiService implements IBookingKoiService {
    private IBookingRepository bookingRepository;
    private IKoiFarmsRepository koiFarmsRepository;
    private IKoiRepository koiRepository;
    private IBookingKoiDetailRepository bookingKoiDetailRepository;
    public BookingKoiService(String name)
    {
        bookingRepository = new BookingRepository(name);
        koiFarmsRepository = new KoiFarmsRepository(name);
        koiRepository = new KoiRepository(name);
        bookingKoiDetailRepository = new BookingKoiDetailRepository(name);

    }

    @Override
    public Bookings createKoiBooking(BookingKoiRequest request, Long bookingTourId,Account staff) {

        Bookings bookingTour = bookingRepository.findById(bookingTourId);
        if(bookingTour==null || bookingTour.getBookingType().equals("Koi Purchase")){
            throw new IllegalArgumentException("Bookings not found");
        }
        Bookings booking = new Bookings();
        booking.setBookingType("Koi Purchase");
        booking.setBookingDate(request.getBookingDate());
        booking.setPaymentMethod(request.getPaymentMethod());
        booking.setCreatedBy(staff);
        booking.setPaymentStatus("pending");
        booking.setVat(request.getVat());
        booking.setDiscountAmount(request.getDiscountAmount());
        bookingRepository.save(booking);

        float totalBookingAmount = 0;

        for (BookingKoiDetailRequest detailRequest : request.getDetails()) {
            KoiFarms koiFarms = koiFarmsRepository.findById(detailRequest.getFarmId());
            if(koiFarms==null){
                throw new IllegalArgumentException("KoiFarms not found");
            }
            Koi koi = koiRepository.findById(detailRequest.getKoiId());
            if(koi==null){
                throw new IllegalArgumentException("Koi not found");
            }
            BookingKoiDetail bookingKoiDetail = new BookingKoiDetail();
            bookingKoiDetail.setKoi(koi);
            bookingKoiDetail.setKoiFarms(koiFarms);
            bookingKoiDetail.setUnitPrice(detailRequest.getUnitPrice());
            bookingKoiDetail.setQuantity(detailRequest.getQuantity());
            bookingKoiDetail.setBooking(booking);
            float totalAmount = detailRequest.getUnitPrice()*detailRequest.getQuantity();
            bookingKoiDetail.setTotalAmount(totalAmount);
            bookingKoiDetailRepository.save(bookingKoiDetail);
            totalBookingAmount+=totalAmount;
        }
        booking.setTotalAmount(totalBookingAmount);
        booking.setVatAmount(request.getVat()*(booking.getTotalAmount()-request.getDiscountAmount()));
        booking.setTotalAmountWithVAT(booking.getTotalAmount() + booking.getVatAmount() - booking.getDiscountAmount());
        booking.setAccount(bookingTour.getAccount());
        bookingRepository.update(booking);
        return booking;
    }

    @Override
    public Bookings getKoiBookings(Long bookingId) {
        return null;
    }

    @Override
    public Bookings updateKoiBooking(BookingUpdate bookingUpdate, Long bookingId,Account staff) {
        Bookings bookings = bookingRepository.findById(bookingId);
        if(bookings==null || bookings.getBookingType().equals("Tour Booking")){
            throw new IllegalArgumentException("Bookings not found");
        }
        bookings.setPaymentMethod(bookingUpdate.getPaymentMethod());
        bookings.setDiscountAmount(bookingUpdate.getDiscountAmount());
        bookings.setVat(bookingUpdate.getVat());
        bookings.setVatAmount(bookingUpdate.getVat() * (bookings.getTotalAmount()-bookingUpdate.getDiscountAmount()));
        bookings.setUpdatedBy(staff);
        bookings.setTotalAmountWithVAT(bookings.getTotalAmount() + bookings.getVatAmount() - bookings.getDiscountAmount());
        Deposit deposit = bookings.getDeposit();
        if(deposit != null){
            deposit.setRemainAmount(bookings.getTotalAmountWithVAT()-deposit.getDepositAmount()+deposit.getShippingFee());
        }
        bookingRepository.save(bookings);
        return bookings;
    }

    @Override
    public List<Bookings> getAllKoiBookings() {
        List<Bookings> bookings = bookingRepository.getAll();
        List<Bookings> bookingKoiList = new ArrayList<>();
        for (Bookings booking : bookings) {
            if(booking.getBookingType().equals("Koi Purchase")){
                bookingKoiList.add(booking);
            }
        }
        return bookingKoiList;
    }

    @Override
    public List<Bookings> getAllKoiBookings(String username) {
        List<Bookings> bookings = bookingRepository.getAll();
        List<Bookings> bookingKoiList = new ArrayList<>();
        for (Bookings booking : bookings) {
            if(booking.getAccount().getUsername().equals(username)&&booking.getBookingType().equals("Koi")){
                bookingKoiList.add(booking);
            }
        }
        return bookingKoiList;
    }

    @Override
    public Bookings deleteKoiBooking(Long bookingId) {
        Bookings bookings = bookingRepository.findById(bookingId);
        bookings.setPaymentStatus("cancel");
        bookingRepository.update(bookings);
        return bookings;
    }
}
