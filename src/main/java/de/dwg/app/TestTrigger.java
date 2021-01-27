package de.dwg.app;

import de.dwg.app.importer.OpenDotaRestClient;
import de.dwg.app.importer.config.OpenDotaConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

// TODO: remove when no longer needed for simple tests
@Component
@RequiredArgsConstructor
public class TestTrigger implements ApplicationListener<ContextRefreshedEvent> {

    private final OpenDotaConfigProperties openDotaConfigProperties;
    private final OpenDotaRestClient openDotaRestClient;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.sleep();

        openDotaRestClient.getPlayersData("107329403");
        openDotaRestClient.getPlayersRecentMatches("107329403");
        openDotaRestClient.getPlayersWordCloud("107329403");
    }

    private void sleep(){
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
