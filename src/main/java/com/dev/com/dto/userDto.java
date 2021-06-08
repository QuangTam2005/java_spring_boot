/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author tamvo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Cartltem")
public class userDto {

    private ObjectId id;
    
    private Integer quanlity;
}
