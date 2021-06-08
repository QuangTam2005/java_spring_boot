
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.service;

import com.dev.com.document.cartltem;
import com.dev.com.document.user;
import static com.microsoft.schemas.office.excel.STTrueFalseBlank.T;
import static com.microsoft.schemas.vml.STTrueFalse.T;
import java.util.List;
import org.apache.poi.ss.formula.functions.T;
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
public class userService {

    @Autowired
    private MongoTemplate mongoTemplate;
// giomsog ki?u tr? v?
    public Page<user> findAllByKeyword(String keyword, Pageable pageable) {
        // câu truy v?n trên csdl
        Query query = new Query();
        // truy v?n phân trang
        query.with(pageable);
        //s?p x?p theo th?i gian
        query.with(Sort.by(Sort.Direction.DESC, "createdDate"));
        if (keyword != null && !keyword.isEmpty()) {
            // t?o câu truy v?n
            Criteria criteria = new Criteria();
            /// add câu truy v?n
            criteria.orOperator(
                    Criteria.where("username").regex(keyword, "i")
            );
            query.addCriteria(criteria);
        }
        System.out.println("query");
        System.out.println(query);
        
        List<user> listDocument;
        // lúc truy v?n cõ s? d? li?u
        listDocument = mongoTemplate.find(query, (Class<user>) user.class);
        /////
        Page<user> page = PageableExecutionUtils.getPage(listDocument, pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), user.class));
        return page;

    }

}
