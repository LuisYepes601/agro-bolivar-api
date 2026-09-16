/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.CLOUDINARY;

import com.nexus.demo.DTOS.GLOBAL.CloudinaryUploadResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
public interface ICloudinaryService {

    public CloudinaryUploadResponse uploadPrymaryFotoPlant(MultipartFile file, String namePlant, String namefile);
    
    public void deleteFile(String public_id);
    
    public CloudinaryUploadResponse uploadFotoPerfil(MultipartFile file, String nameUser, String nameFile);
    
    public CloudinaryUploadResponse uploadPortadaLibro(MultipartFile portada, String nameFile);
    
    public CloudinaryUploadResponse uploadLibro(MultipartFile libro, String nameFile);
}
