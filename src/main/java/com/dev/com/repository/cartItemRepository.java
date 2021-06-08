/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.repository;

import com.dev.com.document.cartltem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tamvo
 */
@Repository
public interface cartItemRepository extends MongoRepository<cartltem, ObjectId>{
    
}
