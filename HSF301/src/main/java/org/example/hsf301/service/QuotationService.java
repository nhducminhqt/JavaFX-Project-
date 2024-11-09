package org.example.hsf301.service;

import org.example.hsf301.controllers.LoginController;
import org.example.hsf301.enums.ApproveStatus;
import org.example.hsf301.enums.BookingType;
import org.example.hsf301.enums.PaymentStatus;
import org.example.hsf301.exceptions.ResourceNotFoundException;
import org.example.hsf301.model.request.QuotationRequest;

import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.Quotations;
import org.example.hsf301.repo.BookingRepository;
import org.example.hsf301.repo.IBookingRepository;
import org.example.hsf301.repo.IQuotationRepository;
import org.example.hsf301.repo.QuotationRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author QuotationService
 */
public class QuotationService implements  IQuotationService{
    private IQuotationRepository quotationRepository;
    private IBookingRepository bookingRepository;
    private Account account;

    public QuotationService(String persistenceName) {
        quotationRepository = new QuotationRepository(persistenceName);
        bookingRepository = new BookingRepository(persistenceName);
    }

    @Override
    public List<Quotations> getQuotationsByBookID(Long bookId) {
        return quotationRepository.findAll().stream()
                .filter(quotations -> quotations.getBooking().getId().equals(bookId))
                .toList();
    }

    @Override
    public List<Quotations> getAllQuotation() {
        return quotationRepository.findAll();
    }

    @Override
    public Quotations createQuotations(QuotationRequest quotationRequest, Account account) throws Exception {
        Bookings bookings = bookingRepository.findById(quotationRequest.getBookingId());
//        if (bookings == null) {
//            throw new ResourceNotFoundException("Booking is null!");
//        }
        bookings.setTotalAmount(quotationRequest.getAmount());
        bookings.setVatAmount((quotationRequest.getAmount() - bookings.getDiscountAmount()) * bookings.getVat()  );
        bookings.setTotalAmountWithVAT(bookings.getTotalAmount() +bookings.getVatAmount() - bookings.getDiscountAmount());

        Quotations quotation = new Quotations();

//        if (bookings.getBookingType() == BookingType.TourBooking) {
            quotation.setAmount(quotationRequest.getAmount());
            quotation.setBooking(bookings);
            quotation.setDescription(quotationRequest.getDescription());
            quotation.setStatus(ApproveStatus.PROCESSING);
            quotation.setApproveTime(LocalDateTime.now());
            //quotation.getCreatedBy()
            quotation.setCreatedBy(account);
            quotationRepository.save(quotation);
       //    }
        return quotation;
    }

    @Override
    public Quotations updateAmountQuotations(Long bookId, float amount) {
        return null;
    }

    @Override
    public Quotations updateStatusQuotations(Long quotationId, ApproveStatus approveStatus) throws Exception {
        Quotations quotations = quotationRepository.findById(quotationId);
        if (quotations == null) {
            throw new ResourceNotFoundException("Quotation not found");
        }
        if(approveStatus==ApproveStatus.FINISH)
        {
            Bookings bookings = bookingRepository.findById(quotations.getBooking().getId());
            bookings.setPaymentStatus(PaymentStatus.PROCESSING);
            bookingRepository.update(bookings);}
         //   quotations.getBooking().setPaymentStatus(PaymentStatus.PROCESSING);}

        quotations.setStatus(approveStatus);
        quotationRepository.save(quotations);

        return quotations;
    }
    @Override
    public boolean deleteQuotations(Long quotationId)throws Exception {
        Quotations quotations = quotationRepository.findById(quotationId);
        if (quotations == null) {
            throw new ResourceNotFoundException("Quotation not found");
        }
       quotationRepository.delete(quotationId);
        return true;
    }

    @Override
    public Quotations adminUpdateStatusQuotations(Long quotationId, ApproveStatus approveStatus) throws  Exception{
        Quotations quotation = quotationRepository.findById(quotationId);
        if (quotation == null) {
            throw new ResourceNotFoundException("Quotation not found");
        }
        if(approveStatus==ApproveStatus.FINISH)
        {
            Bookings bookings = bookingRepository.findById(quotation.getBooking().getId());
            bookings.setPaymentStatus(PaymentStatus.PROCESSING);
            bookings.setTotalAmount(quotation.getAmount());
            bookings.setVatAmount((quotation.getAmount() - bookings.getDiscountAmount()) * bookings.getVat()  );
            bookings.setTotalAmountWithVAT(bookings.getTotalAmount() +bookings.getVatAmount() - bookings.getDiscountAmount());
            bookingRepository.update(bookings);}
        else if(approveStatus==ApproveStatus.REJECTED)
        {
            Bookings bookings = bookingRepository.findById(quotation.getBooking().getId());
            bookings.setPaymentStatus(PaymentStatus.PENDING);
            bookingRepository.update(bookings);}

            quotation.setStatus(approveStatus);
            quotationRepository.save(quotation);
        return quotation;
    }

    @Override
    public Quotations getQuotationById(Long quotationId)throws Exception {
        Quotations quotation = quotationRepository.findById(quotationId);

        if (quotation == null) {
            throw new ResourceNotFoundException("Quotation not found");
        }

        return quotation;
    }
}
