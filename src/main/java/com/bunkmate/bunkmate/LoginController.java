package com.bunkmate.bunkmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
    private UserService userService;
	
    @GetMapping("/login")
    public String roompage(Model model) {
        return "login";
    }
    
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	System.out.println(user.email);
    	System.out.println(user.password);
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }
}
