package com.bunkmate.bunkmate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class RoomListingService {
    @Autowired
    private RoomListingRepository roomListingRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public RoomListing createRoomListing(RoomListing roomListing) {
        roomListingRepository.insert(roomListing);
        return roomListing;
    }

    public RoomListing getRoomListing(String id) {
    	return roomListingRepository.findRoomListingById(id);
    }
    
    public ArrayList<RoomListing> getAllRoomListings() {
    	return new ArrayList<RoomListing>(roomListingRepository.getAllRoomListings());
    }

    public List<RoomListing> getRoomListingByTitle(String title) {
        return roomListingRepository.findRoomListingByTitle(title);
    }
}
