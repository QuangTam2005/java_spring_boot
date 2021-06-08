/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.controller;

import com.dev.com.document.product;
import com.dev.com.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tamvo
 */
@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private productService productService;

    @GetMapping
    public Page<product> getproduct(
            @RequestParam(value = "keyword", required = false) String keyword,
            Pageable pageable) {
        Page<product> page = productService.findAllByKeyword(keyword, pageable);
        return page;
    }
}
