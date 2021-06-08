/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.until;

import com.cloudinary.Cloudinary;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author huunghia
 */
public class Singleton {

    private static Cloudinary cloudinary;

    private static final String CLOUDINARY_CLOUD_NAME = "tr-n-h-u-ngh-a-khu-d-n-c-91b-nguy-n-v-n-linh";
    private static final String CLOUDINARY_API_KEY = "546597688533694";
    private static final String CLOUDINARY_API_SECRET = "S2c8Rby6v0RmpxrwmcD312V-YGg";


    @Bean
    public static Cloudinary getCloudinary() {
        Cloudinary cloudinary = null;
        Map config = new HashMap();
        config.put("cloud_name", CLOUDINARY_CLOUD_NAME);
        config.put("api_key", CLOUDINARY_API_KEY);
        config.put("api_secret", CLOUDINARY_API_SECRET);
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }

}
