/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONFIGS;


import org.passay.PasswordGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author luis
 */
@Configuration
public class PasswordGeneratorConfig {

    @Bean
    public PasswordGenerator passwordGenerator() {
        return new PasswordGenerator();
    }

}
