package pechkovnikita.sigma.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private long id;

    @Column(name = "mark")
    private String mark;

    @Column(name = "owner")
    private String owner;

    @OneToMany
    private List<Booking> bookings = new ArrayList<>();

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Car() {

    }

    public Car(String mark, String owner) {
        this.mark = mark;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void bookCar(Booking booking) {
        bookings.add(booking);
    }
}
