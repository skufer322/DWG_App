package de.dwg.app.importer.player;

import de.dwg.app.importer.config.Placeholders;
import org.springframework.stereotype.Component;

@Component
public class AccountIdInsertionService {

    public String insertAccountIdIntoUrlTemplate(String urlTemplate, String accountId){
        return urlTemplate.replace(Placeholders.ACCOUNT_ID, accountId);
    }
}
