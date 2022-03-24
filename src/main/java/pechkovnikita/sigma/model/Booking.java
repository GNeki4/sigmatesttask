package pechkovnikita.sigma.model;

import javax.persistence.*;

@Entity
@Table(name = "BOOKINGS")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private long id;

    @Column(name = "time")
    private String time;

    @Column(name = "price")
    private String price;

    @ManyToOne
    private Car car;

    @ManyToOne
    private ParkingLot parkingLot;

    public Booking() {

    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Booking(String price, String time) {
        this.price = price;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public Car getCar() {
        return car;
    }
}
