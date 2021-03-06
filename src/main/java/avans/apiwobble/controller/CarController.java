package avans.apiwobble.controller;

import avans.apiwobble.domain.Car;
import avans.apiwobble.repository.CarRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Add a new car by license plate
    @PostMapping("/new")
    public ResponseEntity<HttpStatus> createCar(@RequestBody Car resultCar) {
        String licensePlate = resultCar.getLicensePlate();
        if (carRepository.findCarByLicensePlateIgnoringCase(licensePlate).isEmpty()) {
            Car apiCar = new Car(licensePlate);
            if (apiCar.usesExternal()) {
                resultCar = new Car(licensePlate);
            }
            carRepository.save(resultCar);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } else {
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }

    }

    // Get all cars by request params
    @GetMapping("/filter")
    public List<Car> getAll(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String color,
            @RequestParam(required = false, defaultValue = "0") int min_top_speed,
            @RequestParam(required = false, defaultValue = "2147483647") int max_top_speed,
            @RequestParam(required = false, defaultValue = "2147483647") int max_seconds_to_100,
            @RequestParam(required = false, defaultValue = "0") int min_value,
            @RequestParam(required = false, defaultValue = "2147483647") int max_value,
            @RequestParam(required = false, defaultValue = "1900-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"yyyy"}) Date min_build_date,
            @RequestParam(required = false, defaultValue = "2100-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"yyyy"}) Date max_build_date
    ) {
        List<Car> found = new ArrayList<>(carRepository.findAll());

        //Filter by brand
        if (model != null && !model.isEmpty()) {
            found = found.stream()
                    .filter(car -> model.equals(car.getCarModel()))
                    .collect(Collectors.toList());
        }

        // Filter model
        if (brand != null && !brand.isEmpty()) {
            found = found.stream()
                    .filter(car -> brand.equals(car.getCarBrand()))
                    .collect(Collectors.toList());
        }

        // Filter color
        if (color != null && !color.isEmpty()) {
            found = found.stream()
                    .filter(car -> color.equals(car.getCarColor()))
                    .collect(Collectors.toList());
        }

        // Filter top speed
        if (min_top_speed > 0 || max_top_speed < 2147483647) {
            found = found.stream()
                    .filter(car -> min_top_speed <= car.getCarTopSpeed())
                    .filter(car -> max_top_speed >= car.getCarTopSpeed())
                    .collect(Collectors.toList());
        }

        // Filter by seconds to 100
        if (max_seconds_to_100 < 2147483647) {
            found = found.stream()
                    .filter(car -> max_seconds_to_100 >= car.getSecondsTo100())
                    .collect(Collectors.toList());
        }

        // Filter car value
        if (min_value > 0 || max_value < 2147483647) {
            found = found.stream()
                    .filter(car -> min_value <= car.getCarNewValue())
                    .filter(car -> max_value >= car.getCarNewValue())
                    .collect(Collectors.toList());
        }

        // Filter by date
        found = found.stream()
                .filter(car -> min_build_date.before(car.getCarBuildDate()))
                .filter(car -> max_build_date.after(car.getCarBuildDate()))
                .collect(Collectors.toList());

        return found;
    }

    @GetMapping("/find")
    public List<Car> getAll(@RequestParam String license_plate) {
        List<Car> found = new ArrayList<>();
        if (license_plate != null && !license_plate.isEmpty()) {
            return carRepository.findCarByLicensePlateIgnoringCase(license_plate);
        }

        return found;
    }

    @RequestMapping("")
    @ResponseBody
    public String getCarData(HttpServletRequest request) {

        String carId = request.getParameter("id");

        if (carId.length() != 6)
            return "Not a valid registration";

        return "Return JSON with car data for car " + carId + ".";
    }
}
