/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.service;

import com.dev.com.document.cartltem;
import com.dev.com.dto.userDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author tamvo
 */
@Service
public class cartItemService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Page<cartltem> findAllByKeyword(String keyword, Pageable pageable) {
        Query query = new Query();
        query.with(pageable);
        query.with(Sort.by(Sort.Direction.DESC, "createdDate"));
        if (keyword != null && !keyword.isEmpty()) {
            Criteria criteria = new Criteria();
            criteria.orOperator(
                    Criteria.where("username").regex(keyword, "i")
            );
            query.addCriteria(criteria);
        }
        List<cartltem> listDocument = mongoTemplate.find(query, cartltem.class);
        Page<cartltem> page = PageableExecutionUtils.getPage(listDocument, pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), cartltem.class));
        return page;

    }
}
