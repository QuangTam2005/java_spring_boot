/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.controller;

import com.dev.com.document.user;
import com.dev.com.service.userService;
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
//RestController l� nh?n c�c ��?ng d?n t? fornt-end chuy?n g?i qua serve
@RestController
// �?t t�n ��?ng d?n API
@RequestMapping("/user")
public class userController {
    // Khai b�o t�n l?p mu?n s? d?ng
    @Autowired
    private userService userService;
    //Ph��ng th?c l?y t?t c? danh s�ch tr�n db
    @GetMapping
    public Page<user> getuser(
            @RequestParam(value = "keyword", required = false) String keyword,
            Pageable pageable) {
        //RequestParam nh?n d? li?u t? bi?n 
        Page<user> page = userService.findAllByKeyword(keyword, pageable);
        return page;
    }
}
