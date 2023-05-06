package com.bunkmate.bunkmate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	@Autowired
	private RoomListingService roomListingService;
	
    @GetMapping("/search")
    public String searchpage(@RequestParam(name = "title", defaultValue = "") String title, Model model) {
    	List<RoomListing> listings = roomListingService.getRoomListingByTitle(title);
    	model.addAttribute("listings", listings);
        return "search";
    }
}