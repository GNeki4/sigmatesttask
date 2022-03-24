package pechkovnikita.sigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pechkovnikita.sigma.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findById(long id);
}
