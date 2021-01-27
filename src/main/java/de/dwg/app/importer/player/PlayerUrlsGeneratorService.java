package de.dwg.app.importer.player;

import de.dwg.app.importer.config.OpenDotaConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerUrlsGeneratorService {

    private final OpenDotaConfigProperties openDotaConfigProperties;
    private final AccountIdInsertionService accountIdInsertionService;

    public String getPlayerDataUrl(String accountId) {
        String urlTemplate = openDotaConfigProperties.getBaseUrl() + openDotaConfigProperties.getPlayerUrls().getBaseUrl();

        return accountIdInsertionService.insertAccountIdIntoUrlTemplate(urlTemplate, accountId);
    }

    public String getPlayersRecentMatchesUrl(String accountId) {
        return this.getPlayerDataUrl(accountId) + openDotaConfigProperties.getPlayerUrls().getRecentMatchesSubUrl();
    }

    public String getPlayersWordCloudUrl(String accountId) {
        return this.getPlayerDataUrl(accountId) + openDotaConfigProperties.getPlayerUrls().getWordCloudSubUrl();
    }
}
