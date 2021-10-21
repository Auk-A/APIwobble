package avans.apiwobble.controller;

import avans.apiwobble.domain.Car;
import avans.apiwobble.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carRepository.save(car);
    }

    // Get all cars by model or by brand
    @GetMapping
    public List<Car> getAll(@RequestParam(required = false) String model, @RequestParam(required = false) String brand) {
        List<Car> found = new ArrayList<>();

        if ((model == null || model.isEmpty()) && (brand == null || brand.isEmpty())) {
            found.addAll(carRepository.findAll());
        } else if ((model != null || !model.isEmpty()) && (brand != null || !brand.isEmpty())) {
            found.addAll(carRepository.findCarByCarBrandContainingIgnoringCase(brand));
            found.addAll(carRepository.findCarByCarModelContainingIgnoringCase(model));
        } else if (!model.isEmpty()) {
            found.addAll(carRepository.findCarByCarModelContainingIgnoringCase(model));
        } else {
            found.addAll(carRepository.findCarByCarModelContainingIgnoringCase(brand));
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
