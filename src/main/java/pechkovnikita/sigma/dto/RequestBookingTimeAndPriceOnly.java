package pechkovnikita.sigma.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RequestBookingTimeAndPriceOnly {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String price;
    private String time;

    public RequestBookingTimeAndPriceOnly(String time, String price) {
        this.time = time;
        this.price = price;
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
}
