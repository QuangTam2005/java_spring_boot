/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.service;

import com.dev.com.document.role;
import com.dev.com.document.user;
import com.dev.com.dto.AffectedRowsDto;
import com.dev.com.dto.IdDto;
import com.dev.com.dto.roleDto;
import com.dev.com.repository.roleRepository;
import java.util.List;
import java.util.Objects;
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
public class roleService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private roleRepository roleRepository;

    public Page<role> findAllByKeyword(String keyword, Pageable pageable) {
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
        List<role> listDocument;
        listDocument = mongoTemplate.find(query, (Class<role>) role.class);
        Page<role> page = PageableExecutionUtils.getPage(listDocument, pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), role.class));
        return page;

    }

    public role getDetailRole(ObjectId id) {
        role newRole = roleRepository.getDetailRole(id);
        return newRole;
    }

    public IdDto createRole(roleDto roleDto) {
        // khai báo ð?i tý?ng m?i
        IdDto newIdDto = new IdDto();
        // khai báo ð?i tý?ng m?i
        role newrole = new role();

        if (Objects.nonNull(roleDto.getRoleName())) {
            newrole.setRoleName(roleDto.getRoleName());
        }

        // lýu l?i trên cõ s? d? li?u
        roleRepository.save(newrole);
        // lýu xong th? t? t?o id và tr? v?
        newIdDto.setId(newrole.getId());

        return newIdDto;
    }

    public AffectedRowsDto updateRole(ObjectId id, roleDto roleName) {
        AffectedRowsDto affectedRowsDto = new AffectedRowsDto();
        try {
            role newRole = roleRepository.getDetailRole(id);

            newRole.setRoleName(roleName.getRoleName());
            affectedRowsDto.setAffectedRows(1);
            // lýu l?i trên cõ s? d? li?u
            roleRepository.save(newRole);
        } catch (Exception e) {

        }
        return affectedRowsDto;
    }

    public AffectedRowsDto deleteRole(ObjectId id) {
        AffectedRowsDto affectedRowsDto = new AffectedRowsDto();
        try {
            // ði d? t?m cái id có gi?ng ko r?i tr? v?
            role newRole = roleRepository.getDetailRole(id);
            roleRepository.delete(newRole);
            affectedRowsDto.setAffectedRows(1);
        } catch (Exception e) {
        }
        return affectedRowsDto;
    }

    public AffectedRowsDto deleteAllRole(List<ObjectId> ListId) {
        AffectedRowsDto affectedRowsDto = new AffectedRowsDto();
        if (ListId.size() > 0) {
            for (ObjectId objectId : ListId) {
                role newRole = roleRepository.getDetailRole(objectId);
                roleRepository.delete(newRole);
                affectedRowsDto.setAffectedRows(1);
            }
        }
        return affectedRowsDto;
    }

}
