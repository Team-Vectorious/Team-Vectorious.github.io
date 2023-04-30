package com.bunkmate.bunkmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

import java.util.Map;

@Controller
public class BunkMateController {
    @GetMapping("/")
    public String mainpage(Model model) {
        return "bunkmate";
    }
}
