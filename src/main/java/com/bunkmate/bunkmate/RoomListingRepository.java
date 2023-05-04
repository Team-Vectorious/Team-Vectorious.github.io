package com.bunkmate.bunkmate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomListingRepository extends MongoRepository<RoomListing, ObjectId> {
	@Query("{_id:'?0'}")
    RoomListing findRoomListingById(String name);
	
	@Query("{}")
	List<RoomListing> getAllRoomListings();

	@Query("{title: '?0'}")
	Optional<RoomListing> findRoomListingByTitle(String title);
}