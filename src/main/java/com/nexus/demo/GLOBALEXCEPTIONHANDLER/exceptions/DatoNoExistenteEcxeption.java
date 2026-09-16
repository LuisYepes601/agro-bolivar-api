/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo;

/**
 *
 * @author User
 */
public class DatoNoExistenteEcxeption extends RuntimeException {

    public DatoNoExistenteEcxeption(String message) {
        super(message);
    }

    public DatoNoExistenteEcxeption(String message, Throwable cause) {
        super(message, cause);
    }

}
