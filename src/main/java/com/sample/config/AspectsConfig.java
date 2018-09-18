package com.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("com.sample")
@Profile("aspects")
@EnableAspectJAutoProxy
public class AspectsConfig {

}
