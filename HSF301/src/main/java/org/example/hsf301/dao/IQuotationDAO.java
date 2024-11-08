package org.example.hsf301.dao;

import org.example.hsf301.pojo.Quotations;

import java.util.List;

/**
 * @author IQuotationDAO
 */
public interface    IQuotationDAO {
    public void save(Quotations quotation);
    public List<Quotations> findAll();
    public Quotations findById(Long id);
    public void update(Quotations quotation);
    public void delete(Long id);

}
