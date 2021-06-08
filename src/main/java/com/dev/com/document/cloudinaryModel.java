/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author huunghia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "img")
public class cloudinaryModel {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String url;

    private Integer useCount = 0;

    public cloudinaryModel(String url) {
        this.url = url;
    }

    public cloudinaryModel(String url, Integer useCount) {
        this.url = url;
        this.useCount = useCount;
    }
}
