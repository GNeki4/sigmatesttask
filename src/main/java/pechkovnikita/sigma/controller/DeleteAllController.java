package pechkovnikita.sigma.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pechkovnikita.sigma.repository.BookingRepository;
import pechkovnikita.sigma.repository.ClientCarRepository;
import pechkovnikita.sigma.repository.ParkingLotRepository;

@RestController
@RequestMapping("deleteAll")
@Tag(name = "Delete all")
public class DeleteAllController {
    @Autowired
    private ClientCarRepository carRepo;
    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private ParkingLotRepository parkingLotRepo;

    @DeleteMapping()
    @Operation(summary="Delete all records")
    public String delete() {
        bookingRepo.deleteAll();
        parkingLotRepo.deleteAll();
        carRepo.deleteAll();

        return "All notes deleted successfully";
    }
}
