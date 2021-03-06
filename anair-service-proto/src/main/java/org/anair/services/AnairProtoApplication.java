package org.anair.services;

import lombok.extern.slf4j.Slf4j;
import org.anair.services.interceptor.MDCInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Slf4j
public class AnairProtoApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AnairProtoApplication.class, args);
        log.info("Application Context: {}", context.getApplicationName());
    }

    @Bean
    public ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MDCInterceptor());
    }
}

