package pechkovnikita.sigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pechkovnikita.sigma.model.Car;

public interface ClientCarRepository extends JpaRepository<Car, Long> {
    Car findByOwner(String owner);
    Car findById(long id);
    boolean existsByOwner(String owner);
}
