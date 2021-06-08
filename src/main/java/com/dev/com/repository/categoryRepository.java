/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.repository;

import com.dev.com.document.category;
import com.dev.com.document.role;
import com.dev.com.dto.CategoryDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tamvo
 */
@Repository
public interface categoryRepository extends MongoRepository<category, ObjectId> {

    @Query(value = "{'id': ?0}")
    category getDetailCategory(ObjectId id);

}
