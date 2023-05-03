package com.bunkmate.bunkmate;
import java.util.Base64;

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
    public String base64data;
    
    public Image(Binary data, String contentType) {
        this.data = data;
        this.contentType = contentType;
        this.base64data = Base64.getEncoder().encodeToString(data.getData());
    }
}
