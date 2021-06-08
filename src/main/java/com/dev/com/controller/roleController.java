/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.controller;

import com.dev.com.document.role;
import com.dev.com.dto.AffectedRowsDto;
import com.dev.com.dto.IdDto;
import com.dev.com.dto.roleDto;
import com.dev.com.service.roleService;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tamvo
 */
@RestController
@RequestMapping("/role")
public class roleController {

    @Autowired
    private roleService roleService;

    // l?y h?t trên cõ s? d? li?u
    @GetMapping
    public Page<role> getrole(
            @RequestParam(value = "keyword", required = false) String keyword,
            Pageable pageable) {
        Page<role> page = roleService.findAllByKeyword(keyword, pageable);
        return page;
    }

    // l?y chi ti?t cõ s? d? li?u
    @GetMapping("/{id}")
    public role getDetailRole(
            @PathVariable(value = "id", required = true) ObjectId id
    ) {
        role newRole = roleService.getDetailRole(id);
        return newRole;
    }

    // thêm m?i vào cõ s? d? li?u
    //RequestBody nh?n d? li?u t? json
    @PostMapping
    public ResponseEntity<Object> createRole(@RequestBody @Validated roleDto roleInputDto) {
        IdDto newPage = roleService.createRole(roleInputDto);
        return ResponseEntity.ok(newPage);
    }

    // ch?nh s?a cõ s? d? li?u
    //PathVariable ðý?ng d?n category/5566566656
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRole(
            @PathVariable(value = "id", required = true) ObjectId id,
            @RequestBody @Validated roleDto roleInputDto
    ) {
        AffectedRowsDto affectedRowsDto = roleService.updateRole(id, roleInputDto);
        return ResponseEntity.ok(affectedRowsDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable(value = "id", required = true) ObjectId id) {
        AffectedRowsDto affectedRowsDto = roleService.deleteRole(id);
        return ResponseEntity.ok(affectedRowsDto);
    }

    @DeleteMapping("/--all-role")
    public ResponseEntity<Object> deleteAllRole(
            @RequestParam(value = "id", required = true) List<ObjectId> listId
    ) {
        AffectedRowsDto affectedRowsDto = roleService.deleteAllRole(listId);
        return ResponseEntity.ok(affectedRowsDto);
    }

}
