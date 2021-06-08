/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.controller;

import com.dev.com.document.category;
import com.dev.com.document.category;
import com.dev.com.document.role;
import com.dev.com.dto.AffectedRowsDto;
import com.dev.com.dto.CategoryDto;
import com.dev.com.dto.IdDto;
import com.dev.com.dto.roleDto;
import com.dev.com.service.categoryService;
import com.dev.com.service.categoryService;
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

@RestController
@RequestMapping("/category")
public class categoryController {

    @Autowired
    private categoryService categoryService;

    @GetMapping
    public Page<category> getcategory(
            @RequestParam(value = "keyword", required = false) String keyword,
            Pageable pageable) {
        Page<category> page = categoryService.findAllByKeyword(keyword, pageable);
        return page;
    }
     @GetMapping("/{id}")
    public category getDetailCatetory(
            @PathVariable(value = "id", required = true) ObjectId id
    ) {
        category newCategory = categoryService.getDetailCategory(id);
        return newCategory;
    }
    @PostMapping
    public ResponseEntity<Object> createCategory(@RequestBody @Validated CategoryDto CategoryInputDto) {
        IdDto newPage = categoryService.createCategory(CategoryInputDto);
        return ResponseEntity.ok(newPage);
    }
    //RequestParam category?id=55555
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(
           @PathVariable(value = "id", required = true) ObjectId id,
           @RequestBody @Validated CategoryDto categoryInputDto
           ){
        AffectedRowsDto affectedRowsDto = categoryService.updateCategory(id, categoryInputDto);
        return ResponseEntity.ok(affectedRowsDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(
            @PathVariable(value = "id", required = true) ObjectId id) {
        AffectedRowsDto affectedRowsDto = categoryService.deleteCategory(id);
        return ResponseEntity.ok(affectedRowsDto);
    }

    @DeleteMapping("/--all-role")
    public ResponseEntity<Object> deleteAllCategory(
            @RequestParam(value = "id", required = true) List<ObjectId> listId
    ) {
        AffectedRowsDto affectedRowsDto = categoryService.deleteAllCategory(listId);
        return ResponseEntity.ok(affectedRowsDto);
    }
}
