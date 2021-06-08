/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.repository;

import com.dev.com.document.cloudinaryModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author huunghia
 */
@Repository
public interface cloudinaryRepository extends MongoRepository<cloudinaryModel, ObjectId>{
    
}
