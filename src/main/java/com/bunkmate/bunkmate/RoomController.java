package com.bunkmate.bunkmate;

import java.util.Base64;

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
    	//model.addAttribute("image", listing.image.data.getData());
    	//System.out.println(listing.image.data.getData());
    	//Base64.getEncoder().encodeToString(listing.image.data.getData());
    	
    	model.addAttribute("image", Base64.getEncoder().encodeToString(listing.image.data.getData()));
    	System.out.println(Base64.getEncoder().encodeToString(listing.image.data.getData()));
        return "roompage";
    }
}
