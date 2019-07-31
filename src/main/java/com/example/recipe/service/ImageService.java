package com.example.recipe.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * created by tianyh on 7/30/19 3:49 PM
 */
public interface ImageService {

    void saveImageFile(Long valueOf, MultipartFile file);
}
