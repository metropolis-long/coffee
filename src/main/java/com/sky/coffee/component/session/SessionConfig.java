package com.sky.coffee.component.session;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(RedisSessionProperties.class)

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 100, redisNamespace = "coffee")
public class SessionConfig {


    private final RedisConnectionFactory redisConnectionFactory;

    public SessionConfig(ObjectProvider<RedisConnectionFactory> redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory.getObject();
    }

    @Bean
    public RedisOperations<String, Object> sessionRedisOperations() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(this.redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

}