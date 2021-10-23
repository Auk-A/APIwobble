package avans.apiwobble.controller;

import avans.apiwobble.domain.User;
import avans.apiwobble.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // Get all users by request params
    @GetMapping("/findby")
    public List<User> getAll(
            @RequestParam(required = false, defaultValue = "0") int min_score,
            @RequestParam(required = false, defaultValue = "2147483647") int max_score
    ) {
        List<User> found = new ArrayList<>(userRepository.findAll());

        // Filter by user score
        if (min_score > 0 || max_score < 2147483647) {
            found = found.stream()
                    .filter(user -> min_score <= user.getUserScore())
                    .filter(user -> max_score >= user.getUserScore())
                    .collect(Collectors.toList());
        }

        return found;
    }

    // Find a single user by id, username or email
    @GetMapping("/find")
    public List<User> getAll(@RequestParam(required = false, defaultValue = "-1") long id, @RequestParam(required = false) String user_name, @RequestParam(required = false) String user_mail) {
        List<User> found = new ArrayList<>();
        if (id != -1) {
            return userRepository.findUserById(id);
        } else if(user_name != null && !user_name.isEmpty()){
            return userRepository.findUserByUserNameIgnoringCase(user_name);
        } else if(user_mail != null && !user_mail.isEmpty()){
            return userRepository.findUserByUserMailIgnoringCase(user_mail);
        }
        return found;
    }
}
