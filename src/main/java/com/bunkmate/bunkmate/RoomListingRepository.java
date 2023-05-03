package com.bunkmate.bunkmate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomListingRepository extends MongoRepository<RoomListing, ObjectId> {
	@Query("{_id:'?0'}")
    RoomListing findRoomListingById(String name);
}