package com.training.property_placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:root/test.properties")
public class SampleConfig { 
 @Value("${test.prop}")
 private String attr;

 @Bean
 public SampleService sampleService() {
  return new SampleService(attr);
 }

 @Bean
 public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
  return new PropertySourcesPlaceholderConfigurer();
 }
}