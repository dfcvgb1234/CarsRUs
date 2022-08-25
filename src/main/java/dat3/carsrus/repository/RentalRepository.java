package dat3.carsrus.repository;

import dat3.carsrus.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
