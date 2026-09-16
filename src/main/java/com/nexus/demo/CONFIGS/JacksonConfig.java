/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONFIGS;


import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.cfg.CoercionAction;
import tools.jackson.databind.cfg.CoercionInputShape;

/**
 *
 * @author luis
 */
@Configuration
public class JacksonConfig {

    @Bean
    public JsonMapperBuilderCustomizer customizer() {

        return builder -> {

            builder.withCoercionConfig(String.class, config -> {

                config.setCoercion(
                        CoercionInputShape.Integer,
                        CoercionAction.Fail
                );

                config.setCoercion(
                        CoercionInputShape.Boolean,
                        CoercionAction.Fail
                );
            });
        };
    }
}
