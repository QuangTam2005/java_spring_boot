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
import lombok.Data; //em xem th� vi?n lomnbok
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author tamvo
 */
// khai b�o h�m getter setter
@Data
// h�m x�y d?ng c? ��i s?
@AllArgsConstructor
// h�m x�y d?ng kh�ng c? ��i s?
@NoArgsConstructor
// �?t t�n b?ng tr�n db
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
