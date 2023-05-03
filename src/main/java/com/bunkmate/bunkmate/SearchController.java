package com.bunkmate.bunkmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
	@Autowired
	private RoomListingService roomListingService;
	
    @GetMapping("/search")
    public String searchpage(Model model) {
    	model.addAttribute("user", null);
        return "search";
    }
}