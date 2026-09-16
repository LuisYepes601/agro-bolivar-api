/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONFIGS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.Duration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 *
 * @author luis
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisCacheManager cacheManager(
            RedisConnectionFactory factory) {

        ObjectMapper mapper = new ObjectMapper();

        // Soporte para LocalDateTime, LocalDate, etc.
        mapper.registerModule(new JavaTimeModule());

        mapper.activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL
        );

        GenericJackson2JsonRedisSerializer serializer
                = new GenericJackson2JsonRedisSerializer(mapper);

        RedisCacheConfiguration config
                = RedisCacheConfiguration
                        .defaultCacheConfig()
                        .serializeValuesWith(
                                RedisSerializationContext.SerializationPair
                                        .fromSerializer(serializer)
                        );

        RedisCacheConfiguration confGeneros = config.entryTtl(Duration.ofHours(1));

        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .withCacheConfiguration("generos", confGeneros)
                .build();
    }
}
