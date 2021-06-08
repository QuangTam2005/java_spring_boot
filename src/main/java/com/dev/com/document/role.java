/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author tamvo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// tên b?ng trên cõ s? d? li?u
@Document(collection = "Role")
public class role {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String roleName;

    private Integer useCount = 0;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdDate = new Date();
    
    public role(String roleName){
        
    }
}
