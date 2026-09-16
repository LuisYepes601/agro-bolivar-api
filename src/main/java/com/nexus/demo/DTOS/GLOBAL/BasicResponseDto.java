/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.GLOBAL;

/**
 *
 * @author luis
 */
public class BasicResponseDto {

    private String message;

    public BasicResponseDto(String message) {
        this.message = message;
    }

    public BasicResponseDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
