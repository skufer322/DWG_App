package de.dwg.app.importer.player;

import de.dwg.app.importer.config.Placeholders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AccountIdInsertionServiceTest {

    private static final String ANY_URL_BASE = "https://any.opendota.com/url/to/players/";
    private static final String EMPTY_STRING = "";

    private AccountIdInsertionService underTest;

    @BeforeEach
    void setup() {
        underTest = new AccountIdInsertionService();
    }

    @ParameterizedTest(name = "{index} - accountId={0}, suffix={1}")
    @MethodSource("provideUrlTemplatesAndAccountIdsForTest")
    void shouldReplaceAccountIdPlaceHolder_withAccountId(String accountId, String suffix) {
        String urlTemplate = composeUrlTemplate(suffix);

        String processedUrl = underTest.insertAccountIdIntoUrlTemplate(urlTemplate, accountId);

        assertThat(processedUrl).isEqualTo(ANY_URL_BASE + accountId + suffix);
    }

    private static Stream<Arguments> provideUrlTemplatesAndAccountIdsForTest() {
        return Stream.of(
                Arguments.of("ANY_ACCOUNT_ID_1", EMPTY_STRING),
                Arguments.of("ANY_ACCOUNT_ID_2", "/anySuffix_2"),
                Arguments.of("ANY_ACCOUNT_ID_3", "/anySuffix_3")
        );
    }

    private static String composeUrlTemplate(String suffix) {
        return ANY_URL_BASE + Placeholders.ACCOUNT_ID + suffix;
    }
}
