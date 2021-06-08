/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.service;

import com.dev.com.document.category;
import com.dev.com.document.role;
import com.dev.com.dto.AffectedRowsDto;
import com.dev.com.dto.CategoryDto;
import com.dev.com.dto.IdDto;
import com.dev.com.dto.roleDto;
import com.dev.com.repository.categoryRepository;
import com.google.common.base.Strings;
import java.util.List;
import java.util.Objects;
import jdk.jfr.Category;
import org.bson.types.ObjectId;
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
public class categoryService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private categoryRepository categoryRepository;

    public Page<category> findAllByKeyword(String keyword, Pageable pageable) {
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
        List<category> listDocument;
        listDocument = mongoTemplate.find(query, (Class<category>) category.class);
        Page<category> page = PageableExecutionUtils.getPage(listDocument, pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), category.class));
        return page;

    }

    public category getDetailCategory(ObjectId id) {
        category newCategory = categoryRepository.getDetailCategory(id);
        return newCategory;
    }

    public IdDto createCategory(CategoryDto CategoryDto) {
        System.out.print(CategoryDto);
        IdDto newIdDto = new IdDto();
        category newcategory = new category();
        if (Objects.nonNull(CategoryDto.getCategory_name())) {
            newcategory.setCategory_name(CategoryDto.getCategory_name());
        }
        categoryRepository.save(newcategory);
        newIdDto.setId(newcategory.getId());
        return newIdDto;

    }

    public AffectedRowsDto updateCategory(ObjectId id, CategoryDto category_name) {
        AffectedRowsDto affectedRowsDto = new AffectedRowsDto();
        try {
            category newCategory = categoryRepository.findById(id).orElse(null);
            System.out.println(newCategory);
            newCategory.setCategory_name(category_name.getCategory_name());
            affectedRowsDto.setAffectedRows(1);
            categoryRepository.save(newCategory);
        } catch (Exception e) {

        }
        return affectedRowsDto;
    }

    public AffectedRowsDto deleteCategory(ObjectId id) {
        AffectedRowsDto affectedRowsDto = new AffectedRowsDto();
        try {
            category newCategory = categoryRepository.getDetailCategory(id);
            categoryRepository.delete(newCategory);
            affectedRowsDto.setAffectedRows(1);
        } catch (Exception e) {
        }
        return affectedRowsDto;
    }

    public AffectedRowsDto deleteAllCategory(List<ObjectId> ListId) {
        AffectedRowsDto affectedRowsDto = new AffectedRowsDto();
        if (ListId.size() > 0) {
            for (ObjectId objectId : ListId) {
                category newCategory = categoryRepository.getDetailCategory(objectId);
                categoryRepository.delete(newCategory);
                affectedRowsDto.setAffectedRows(1);
            }
        }
        return affectedRowsDto;
    }

}
