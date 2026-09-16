/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.GLOBAL;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author luis
 */
public class CloudinaryUploadResponse {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String publicId;
    
     @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String secureUrl;

    public CloudinaryUploadResponse(String publicId, String secureUrl) {
        this.publicId = publicId;
        this.secureUrl = secureUrl;
    }

    public CloudinaryUploadResponse() {
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getSecureUrl() {
        return secureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        this.secureUrl = secureUrl;
    }
     
     
}
