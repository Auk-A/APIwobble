package avans.apiwobble;

import avans.apiwobble.domain.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class ApiWobbleApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(ApiWobbleApplication.class, args);
    }


}
