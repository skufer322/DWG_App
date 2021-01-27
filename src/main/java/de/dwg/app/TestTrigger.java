package de.dwg.app;

import de.dwg.app.importer.config.OpenDotaConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

// TODO: remove when no longer needed for simple tests
@Component
@RequiredArgsConstructor
public class TestTrigger implements ApplicationListener<ContextRefreshedEvent>  {

    private final OpenDotaConfigProperties openDotaConfigProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println(openDotaConfigProperties.getBaseUrl());
        System.out.println(openDotaConfigProperties.getPlayerUrls().getBaseUrl());
        System.out.println(openDotaConfigProperties.getPlayerUrls().getRecentMatchesSubUrl());
        System.out.println(openDotaConfigProperties.getPlayerUrls().getWordcloudSubUrl());
    }
}
