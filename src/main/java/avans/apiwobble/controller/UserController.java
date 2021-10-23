package avans.apiwobble.controller;

import avans.apiwobble.domain.Car;
import avans.apiwobble.domain.User;
import avans.apiwobble.repository.CarRepository;
import avans.apiwobble.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    @PostMapping("/new")
    public ResponseEntity<HttpStatus> createUser(@RequestBody User newUser) {
        String userName = newUser.getUserName();
        String userMail = newUser.getUserMail();
        if (userRepository.findUserByUserNameIgnoringCase(userName).isEmpty() && userRepository.findUserByUserMailIgnoringCase(userMail).isEmpty()) {
            userRepository.save(newUser);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } else {
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }

    }

}
