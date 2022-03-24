package pechkovnikita.sigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pechkovnikita.sigma.model.ParkingLot;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    ParkingLot findByPlace(String place);
    ParkingLot findById(long id);
}
