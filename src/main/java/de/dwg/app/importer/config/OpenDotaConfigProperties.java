package de.dwg.app.importer.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "opendota")
@Validated
@Getter
@Setter
public class OpenDotaConfigProperties {

    @NotBlank
    private String baseUrl;
    @NotNull
    private OpenDotaConfigProperties.PlayerUrls playerUrls;

    @Validated
    @Data
    public static class PlayerUrls {
        @NotBlank
        String baseUrl;
        @NotBlank
        String recentMatchesSubUrl;
        @NotBlank
        String wordcloudSubUrl;
    }
}
