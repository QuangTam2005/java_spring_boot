/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dev.com.document.cloudinaryModel;
import com.dev.com.until.Singleton;
import com.dev.com.dto.cloudinaryDto;
import com.dev.com.repository.cloudinaryRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author huunghia
 */
@Service
public class cloudinaryService {
    @Autowired
    private cloudinaryRepository cloudinaryRepository;
    
    public cloudinaryModel upload(MultipartFile file) {
        try {
            Map<cloudinaryDto, Object> uploadResult = Singleton.getCloudinary().uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String url = (String) uploadResult.get("url");
            cloudinaryModel newCloudinary = new cloudinaryModel(url, 0);
            cloudinaryRepository.save(newCloudinary);
            return newCloudinary;
        } catch (Exception ex) {
            return null;
        }

    }
}
