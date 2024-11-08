package org.example.hsf301.service;

import org.example.hsf301.enums.ApproveStatus;

import org.example.hsf301.model.request.QuotationRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Quotations;

import java.util.List;

/**
 * @author IQuotationService
 */
public interface IQuotationService {
    List<Quotations> getQuotationsByBookID(Long bookId);

    List<Quotations> getAllQuotation();

    Quotations createQuotations(QuotationRequest quotations , Account account) throws Exception;

    Quotations updateAmountQuotations(Long bookId, float amount);

    Quotations updateStatusQuotations(Long quotationId, ApproveStatus approveStatus) throws Exception;

    boolean deleteQuotations(Long quotationId) throws Exception;

    Quotations adminUpdateStatusQuotations(Long quotationId,ApproveStatus approveStatus)throws Exception;

    Quotations getQuotationById(Long quotationId) throws  Exception;
}
