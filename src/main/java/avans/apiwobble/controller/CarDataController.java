package avans.apiwobble.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/car")
public class CarDataController {

    @RequestMapping("")
    @ResponseBody
    public String getCarData(HttpServletRequest request){

        String carId = request.getParameter("id");

        if(carId.length() != 6)
            return "Not a valid registration";

        return "Return JSON with car data for car "+ carId + ".";
    }
}
