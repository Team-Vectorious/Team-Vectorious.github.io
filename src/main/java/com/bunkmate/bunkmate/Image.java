package com.bunkmate.bunkmate;
import org.bson.types.Binary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    public Binary data;
    public String contentType;
}
