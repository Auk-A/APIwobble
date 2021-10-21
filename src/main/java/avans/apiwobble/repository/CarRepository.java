package avans.apiwobble.repository;

import avans.apiwobble.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarByCarModelIgnoringCase(String model);
    List<Car> findCarByCarBrandIgnoringCase(String brand);
    List<Car> findCarByCarModelAndCarBrandIgnoringCase(String model, String brand);
    List<Car> findCarByLicensePlateIgnoringCase(String licensePlate);
}