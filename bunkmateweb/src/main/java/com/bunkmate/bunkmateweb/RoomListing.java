package com.bunkmate.bunkmateweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roomListings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomListing {
    @Id
    private ObjectId id;
    private String body;

    public RoomListing(String body) {
        this.body = body;
    }
}
