package de.dwg.app.importer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final RestTemplateBuilder restTemplateBuilder;

    @Bean(name = "openDotaRestTemplate")
    public RestTemplate getOpenDotaRestTemplate(){
        return restTemplateBuilder.build();
    }
}
