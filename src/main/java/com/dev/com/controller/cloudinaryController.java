/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.controller;

import com.dev.com.document.cloudinaryModel;
import com.dev.com.dto.cloudinaryDto;
import com.dev.com.service.cloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author huunghia
 */
@RestController
@RequestMapping("/upload")
public class cloudinaryController {

    @Autowired
    private cloudinaryService cloudinaryService;

    @PostMapping
    public cloudinaryModel uploadFile(@RequestParam("file") MultipartFile file) {
        cloudinaryModel url = cloudinaryService.upload(file);
        return  url;
    }
}
