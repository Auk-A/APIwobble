package avans.apiwobble.repository;

import avans.apiwobble.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarByModelContainingIgnoringCase(String model);
    List<Car> findCarByBrandContainingIgnoringCase(String brand);
}
