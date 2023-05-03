package com.bunkmate.bunkmate;

import java.util.Base64;

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
    public String roompage(Model model) {
    	//model.addAttribute("listing", listing);
    	//model.addAttribute("image", Base64.getEncoder().encodeToString(listing.image.data.getData()));
        return "search";
    }
}
