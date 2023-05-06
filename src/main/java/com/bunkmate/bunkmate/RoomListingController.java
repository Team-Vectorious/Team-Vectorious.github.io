package com.bunkmate.bunkmate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RoomListingController {
    @Autowired
    private RoomListingService roomListingService;

    @GetMapping("/roomlisting")
    public String roomListingPage(Model model) {
        return "createroomlisting";
    }
}
