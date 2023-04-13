package com.bunkmate.bunkmateweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/roomlistings")
public class RoomListingController {
    @Autowired
    private RoomListingService roomListingService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<RoomListing> createRoomListing(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<RoomListing>(roomListingService.createRoomListing(payload.get("body"), payload.get("email")), HttpStatus.CREATED);
    }
}
