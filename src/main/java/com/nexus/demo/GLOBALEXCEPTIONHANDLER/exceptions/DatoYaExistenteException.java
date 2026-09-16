/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nexus.demo;


/**
 *
 * @author Usuario
 */
public class DatoYaExistenteException extends RuntimeException{

    public DatoYaExistenteException(String message) {
        super(message);
    }

    public DatoYaExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
