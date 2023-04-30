package com.bunkmate.bunkmate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "roomListings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomListing {
    @Id
    private ObjectId id;
    public String body="";
    
    public String title;
    public String description;
    public Double price;
    public String address;

    public RoomListing(String body) {
        this.body = body;
    }
}
