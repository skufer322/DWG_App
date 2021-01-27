package de.dwg.app.importer;

import de.dwg.app.importer.player.AccountIdInsertionService;
import de.dwg.app.importer.player.PlayerUrlsGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class OpenDotaRestClient {

    private final PlayerUrlsGeneratorService playerUrlsGeneratorService;
    private final AccountIdInsertionService accountIdInsertionService;

    private final RestTemplate openDotaRestTemplate;

    public void getPlayersData(String accountId) {
        final String requestUrl = playerUrlsGeneratorService.getPlayerDataUrl(accountId);

        System.out.println(requestUrl);
//        ResponseEntity<String> responseEntity = openDotaRestTemplate.getForEntity(requestUrl, String.class);
//
//        System.out.println(responseEntity.getBody());
    }

    public void getPlayersRecentMatches(String accountId) {
        final String requestUrl = playerUrlsGeneratorService.getPlayersRecentMatchesUrl(accountId);

        System.out.println(requestUrl);
    }

    public void getPlayersWordCloud(String accountId) {
        final String requestUrl = playerUrlsGeneratorService.getPlayersWordCloudUrl(accountId);

        System.out.println(requestUrl);
    }
}
