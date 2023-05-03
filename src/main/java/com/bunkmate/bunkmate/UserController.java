package com.bunkmate.bunkmate;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//@RestController
//@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/signuppage")
    public String roomListingPage(Model model) {
        return "signup/signup";
    }

//    @GetMapping("/{firstName}")
//    public ResponseEntity<Optional<User>> getUserByFirstName(@PathVariable String firstName) {
//        return new ResponseEntity<Optional<User>>(userService.singleUserByFirstName(firstName), HttpStatus.OK);
//    }

    @GetMapping("/{lastName}")
    public ResponseEntity<List<User>> getUserByLastName(@PathVariable String lastName) {
        return new ResponseEntity<List<User>>(userService.findUserByLastName(lastName), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }



}
