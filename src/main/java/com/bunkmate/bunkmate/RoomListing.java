package com.bunkmate.bunkmate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.stereotype.Component;
import org.bson.types.Binary;

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
    public int price;
    public String address;
    
    @DocumentReference
    public User user;

    public Image image;
    
    public RoomListing(String body) {
        this.body = body;
    }
}
