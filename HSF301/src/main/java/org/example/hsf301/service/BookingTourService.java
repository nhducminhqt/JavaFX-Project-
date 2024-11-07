package org.example.hsf301.service;

import org.example.hsf301.enums.BookingType;
import org.example.hsf301.enums.PaymentStatus;
import org.example.hsf301.model.request.BookingTourDetailRequest;
import org.example.hsf301.model.request.BookingTourRequest;
import org.example.hsf301.model.request.BookingUpdate;
import org.example.hsf301.pojo.*;
import org.example.hsf301.repo.*;
import java.util.ArrayList;
import java.util.List;

public class BookingTourService implements IBookingTourService {
    private IBookingRepository bookingRepository;
    private IKoiFarmsRepository koiFarmsRepository;
    private ITourRepository tourRepository;
    private IBookingTourDetailRepository bookingTourDetailRepository;
    public BookingTourService(String name)
    {
        bookingRepository = new BookingRepository(name);
        koiFarmsRepository = new KoiFarmsRepository(name);
        tourRepository = new TourRepository(name);
        bookingTourDetailRepository = new BookingTourDetailRepository(name);

    }

    @Override
    public Bookings createTourBooking(BookingTourRequest request, Account account) {
        Bookings booking = new Bookings();
        booking.setBookingType(BookingType.TourBooking);
        booking.setBookingDate(request.getBookingDate());
        booking.setPaymentMethod(request.getPaymentMethod());
        booking.setCreatedBy(account);
        booking.setPaymentStatus(PaymentStatus.pending);
        booking.setVat(request.getVat());
        booking.setDiscountAmount(request.getDiscountAmount());
        bookingRepository.save(booking);

        float totalBookingAmount = 0;
        for(BookingTourDetailRequest detailRequest:request.getDetails())
        {
            Tours tours = tourRepository.findById(detailRequest.getTourID());
            if (tours==null)
                throw new IllegalArgumentException("Tours not found");
            BookingTourDetail bookingTourDetail = new BookingTourDetail();
            bookingTourDetail.setBooking(booking);
            bookingTourDetail.setParticipant(detailRequest.getParticipant());
            bookingTourDetail.setTourId(tours);
            bookingTourDetail.setTotalAmount(detailRequest.getParticipant()*tours.getUnitPrice());
            totalBookingAmount += bookingTourDetail.getTotalAmount();
            bookingTourDetailRepository.save(bookingTourDetail);

        }
        booking.setTotalAmount(totalBookingAmount);
        booking.setVatAmount(request.getVat()*(booking.getTotalAmount()-request.getDiscountAmount()));
        booking.setTotalAmountWithVAT(booking.getTotalAmount() + booking.getVatAmount() - booking.getDiscountAmount());
        booking.setAccount(account);
        bookingRepository.update(booking);
        return booking;
    }

    @Override
    public Bookings getTourBookings(Long bookingId) {
        return null;
    }

    @Override
    public Bookings updateTourBooking(BookingUpdate update, Long bookingId, Account account) {
        Bookings bookings = bookingRepository.findById(bookingId);
        if(bookings==null || bookings.getBookingType()==BookingType.KoiPurchase){
            throw new IllegalArgumentException("Bookings not found");
        }
        bookings.setPaymentMethod(update.getPaymentMethod());
        bookings.setDiscountAmount(update.getDiscountAmount());
        bookings.setVat(update.getVat());
        bookings.setVatAmount(update.getVat() * (bookings.getTotalAmount()-update.getDiscountAmount()));
        bookings.setUpdatedBy(account);
        bookings.setTotalAmountWithVAT(bookings.getTotalAmount() + bookings.getVatAmount() - bookings.getDiscountAmount());
        Deposit deposit = bookings.getDeposit();
        if(deposit != null){
            deposit.setRemainAmount(bookings.getTotalAmountWithVAT()-deposit.getDepositAmount()+deposit.getShippingFee());
        }
        bookingRepository.save(bookings);
        return bookings;
    }

    @Override
    public List<Bookings> getAllTourBookings() {
        List<Bookings> bookings = bookingRepository.getAll();
        List<Bookings> bookingKoiList = new ArrayList<>();
        for (Bookings booking : bookings) {
            if(booking.getBookingType()==BookingType.TourBooking){
                bookingKoiList.add(booking);
            }
        }
        return bookingKoiList;
    }

    @Override
    public List<Bookings> getAllTourBookings(String username) {
        List<Bookings> bookings = bookingRepository.getAll();
        List<Bookings> bookingTourList = new ArrayList<>();
        for (Bookings booking : bookings) {
            if(booking.getAccount().getUsername().equals(username)&&booking.getBookingType()==BookingType.TourBooking){
                bookingTourList.add(booking);
            }
        }
        return bookingTourList;
    }

    @Override
    public Bookings deleteTourBooking(Long bookingId) {
        Bookings bookings = bookingRepository.findById(bookingId);
        bookings.setPaymentStatus(PaymentStatus.cancel);
        bookingRepository.update(bookings);
        return bookings;
    }
}
