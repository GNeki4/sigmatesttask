package pechkovnikita.sigma.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pechkovnikita.sigma.dto.RequestBooking;
import pechkovnikita.sigma.dto.RequestBookingTimeAndPriceOnly;
import pechkovnikita.sigma.exception.NotFoundException;
import pechkovnikita.sigma.model.Booking;
import pechkovnikita.sigma.model.Car;
import pechkovnikita.sigma.model.ParkingLot;
import pechkovnikita.sigma.repository.BookingRepository;
import pechkovnikita.sigma.repository.ClientCarRepository;
import pechkovnikita.sigma.repository.ParkingLotRepository;

import java.util.List;

@RestController
@RequestMapping("booking")
@Tag(name = "Booking")
public class BookingController {
    @Autowired
    private ClientCarRepository carRepo;
    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private ParkingLotRepository parkingLotRepo;

    @GetMapping
    @Operation(summary = "Get all bookings")
    public List<Booking> list() {
        return bookingRepo.findAll();
    }

    @PostMapping
    @Operation(summary = "Book parking lot")
    public Booking book(@RequestBody RequestBooking message) {
        Car car = carRepo.findByOwner(message.getOwner());
        if (car == null)
            throw new NotFoundException();
        ParkingLot parkingLot = parkingLotRepo.findByPlace(message.getPlace());
        if (parkingLot == null)
            throw new NotFoundException();
        Booking booking = new Booking(message.getPrice(), message.getTime());
        booking.setCar(car);
        booking.setParkingLot(parkingLot);

        bookingRepo.save(booking);
        parkingLotRepo.save(parkingLot);
        carRepo.save(car);

        return booking;
    }

    @PutMapping("{id}")
    @Operation(summary="Edit booking")
    public Booking update(@RequestParam long id, @RequestBody RequestBookingTimeAndPriceOnly message) {
        Booking booking = bookingRepo.findById(id);
        if (booking == null)
            throw new NotFoundException();
        booking.setTime(message.getTime());
        booking.setPrice(message.getPrice());
        return bookingRepo.save(booking);
    }
}
