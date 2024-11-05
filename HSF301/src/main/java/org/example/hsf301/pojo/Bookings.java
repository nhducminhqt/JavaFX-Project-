package org.example.hsf301.pojo;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "account_id")
    private Account account;


    @Column(name = "booking_type")
    private String bookingType;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "total_amount")
    private float totalAmount;

    @Column(name = "total_amount_with_vat")
    private float totalAmountWithVAT;

    @Column(name = "discount_amount")
    private float discountAmount;

    @Column(name = "VAT")
    private float vat;

    @Column(name = "VAT_amount")
    private float vatAmount;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "paymentDate")
    private LocalDate paymentDate;

    //here mapping quotation table
    @OneToMany(mappedBy = "booking", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Quotations> quotations;

    //mapped By same name with ManyToOne annotation
    @OneToMany(mappedBy = "booking", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<BookingTourDetail> bookingTourDetails;

    @OneToOne(mappedBy = "booking", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Deposit deposit;

    @OneToMany(mappedBy = "booking", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<DeliveryHistory> deliveryHistory;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private Delivery delivery;

    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "created_by")
    private Account createdBy;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "updated_by")
    private Account updatedBy;

    @PrePersist
    protected void onCreate(){
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedDate = LocalDateTime.now();
    }

}
