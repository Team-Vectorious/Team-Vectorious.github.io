package com.bunkmate.bunkmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {
    @GetMapping("/signup")
    public String roompage(Model model) {
        return "signup/signup";
    }
}
