/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

/**
 *
 * @author tamvo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdDto {

    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    ObjectId id;
}
