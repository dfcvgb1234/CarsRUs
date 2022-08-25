package dat3.carsrus.repository;

import dat3.carsrus.entity.RentalCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RentalCompanyRepository extends JpaRepository<RentalCompany, Integer> {
}
