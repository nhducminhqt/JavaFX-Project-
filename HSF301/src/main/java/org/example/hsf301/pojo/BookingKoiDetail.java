package org.example.hsf301.pojo;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "booking_koi_detail")
public class BookingKoiDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "koi_id")
    private Koi koi;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "booking_id")
    private Bookings booking;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_amount")
    private float totalAmount;

    @Column(name = "unit_Price")
    private float unitPrice;

    public BookingKoiDetail(Bookings booking, Koi koi, int quantity, float unitPrice) {
        this.booking =booking;
        this.koi=koi;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
    }
}
