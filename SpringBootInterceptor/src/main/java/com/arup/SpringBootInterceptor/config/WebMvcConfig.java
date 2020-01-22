package com.arup.SpringBootInterceptor.config;

import com.arup.SpringBootInterceptor.interceptor.AdminInterceptor;
import com.arup.SpringBootInterceptor.interceptor.LogInterceptor;
import com.arup.SpringBootInterceptor.interceptor.OldLoginInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class WebMvcConfig implements  WebMvcConfigurer {
 
   //
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      // LogInterceptor apply to all URLs.
      registry.addInterceptor(new LogInterceptor());
 
      // Old Login url, no longer use.
      // Use OldURLInterceptor to redirect to a new URL.
      registry.addInterceptor(new OldLoginInterceptor()).addPathPatterns("/admin/oldLogin");
 
      // This interceptor apply to URL like /admin/*
      // Exclude /admin/oldLogin
      registry.addInterceptor(new AdminInterceptor()) .addPathPatterns("/admin/*").excludePathPatterns("/admin/oldLogin");
   }
 
}