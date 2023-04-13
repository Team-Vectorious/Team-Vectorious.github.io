package com.bunkmate.bunkmateweb;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
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
    public ResponseEntity<User> createRoomListing(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }



}
