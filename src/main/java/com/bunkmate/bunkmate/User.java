package com.bunkmate.bunkmate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.List;

@Document(collection = "Users")
@Data //uses lombok to create all getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String password;
}
