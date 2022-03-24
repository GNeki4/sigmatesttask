package pechkovnikita.sigma.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pechkovnikita.sigma.dto.RequestParkingLot;
import pechkovnikita.sigma.exception.NotFoundException;
import pechkovnikita.sigma.model.ParkingLot;
import pechkovnikita.sigma.repository.ParkingLotRepository;

import java.util.List;

@RestController
@RequestMapping("parkingLot")
@Tag(name="Parking lot")
public class ParkingLotController {
    @Autowired
    private ParkingLotRepository parkingLotRepo;

    @GetMapping
    @Operation(summary="Get all ParkingLots")
    public List<ParkingLot> list() {
        return parkingLotRepo.findAll();
    }

    @PostMapping
    @Operation(summary="Add new ParkingLot")
    public ParkingLot create(@RequestBody RequestParkingLot message) {
        ParkingLot parkingLot = new ParkingLot(message.getPlace());

        return parkingLotRepo.save(parkingLot);
    }

    @PutMapping("{id}")
    @Operation(summary="Edit ParkingLot")
    public ParkingLot update(@RequestParam long id, @RequestBody RequestParkingLot message) {
        ParkingLot parkingLot = parkingLotRepo.findById(id);
        if (parkingLot == null)
            throw new NotFoundException();
        parkingLot.setPlace(message.getPlace());
        return parkingLotRepo.save(parkingLot);
    }
}
