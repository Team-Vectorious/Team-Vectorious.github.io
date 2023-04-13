package com.bunkmate.bunkmateweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class RoomListingService {
    @Autowired
    private RoomListingRepository roomListingRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public RoomListing createRoomListing(String body, String email) {
        RoomListing roomListing = roomListingRepository.insert(new RoomListing(body));

        mongoTemplate.update(User.class)
                .matching(Criteria.where("email").is(email))
                .apply(new Update().push("roomListingIds").value(roomListing))
                .first();

        return roomListing;
    }
}
