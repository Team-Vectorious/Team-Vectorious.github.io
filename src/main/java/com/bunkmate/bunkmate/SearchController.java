package com.bunkmate.bunkmate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String searchpage(Model model) {
        return "search";
    }
}
