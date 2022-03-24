package pechkovnikita.sigma.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pechkovnikita.sigma.exception.NotFoundException;
import pechkovnikita.sigma.model.Car;
import pechkovnikita.sigma.repository.ClientCarRepository;
import pechkovnikita.sigma.dto.RequestCar;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("clientCar")
@Tag(name="Clients & Cars")
public class CarController {
    @Autowired
    private ClientCarRepository carRepo;

    @GetMapping
    @Operation(summary="Get all Cars")
    public List<Car> list() {
        return carRepo.findAll();
    }

    @PostMapping
    @Operation(summary="Add new Car")
    public Car create(@RequestBody RequestCar message) {
        Car car = new Car(message.getMark(), message.getOwner());
        carRepo.save(car);

        return car;
    }

    @PutMapping("{id}")
    @Operation(summary="Edit Car")
    public Car update(@RequestParam long id, @RequestBody RequestCar message) {
        Car car = carRepo.findById(id);
        if (car == null)
            throw new NotFoundException();
        car.setMark(message.getMark());
        car.setOwner(message.getOwner());
        return carRepo.save(car);
    }
}
