package com.github.bhrother

import com.github.bhrother.interceptors.FullLoggingInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class ApplicationConfiguration {

  @Autowired
  FullLoggingInterceptor fullLoggingInterceptor

  @Bean
  RestTemplate restTemplate(){
    RestTemplate restTemplate = new RestTemplate()
    restTemplate.interceptors = [fullLoggingInterceptor]
    restTemplate
  }
}
