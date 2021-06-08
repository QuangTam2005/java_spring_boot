/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.document;

import com.dev.com.pojo.name;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data; //em xem thý vi?n lomnbok
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author tamvo
 */
// khai báo hàm getter setter
@Data
// hàm xây d?ng c? ðôi s?
@AllArgsConstructor
// hàm xây d?ng không c? ðôi s?
@NoArgsConstructor
// ð?t tên b?ng trên db
@Document(collection = "users")
public class user {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    
    private String username;
    
    private String password;
    
    private String avatar;
    
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId role;
    
    private Integer useCount = 0;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    
    private Date createdDate = new Date();
    private name name;

  
}
