package com.bunkmate.bunkmate;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomController {
	@Autowired
    private RoomListingService roomListingService;
	
    @GetMapping("/room")
    public String roompage(@RequestParam String id, Model model) {
    	RoomListing listing = roomListingService.getRoomListing(id);
    	model.addAttribute("listing", listing);
        return "roompage";
    }

    @GetMapping("/findlisting")
    public String foundListing(@RequestParam String title, Model model) {
        Optional<RoomListing> listing = roomListingService.getRoomListingByTitle(title);
        model.addAttribute("listing", listing);
        return "foundlisting";
    }
}
