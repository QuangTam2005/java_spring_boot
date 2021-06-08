/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.controller;

import com.dev.com.document.cartltem;
import com.dev.com.dto.userDto;
import com.dev.com.service.cartItemService;
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
@RequestMapping("/cartItem")
public class cartItemController {

    @Autowired
    private cartItemService cartItemService;

    @GetMapping("/search")
    public Page<cartltem> getCartItem(
            @RequestParam(value = "keyword", required = false) String keyword,
            Pageable pageable
    ) {
        Page<cartltem> page = cartItemService.findAllByKeyword(keyword, pageable);
        return page;
    }
}
