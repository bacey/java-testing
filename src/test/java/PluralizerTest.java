import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PluralizerTest {

    private final Map<String, String> dictionaryOfIrregularPlurals = ImmutableMap.of(
            "fish", "fish",
            "sheep", "sheep");

    private final Pluralizer pluralizer = new Pluralizer(dictionaryOfIrregularPlurals);


    @Test
    public void pluralizerAppendsAnSToTheEndOfTheSingularWord() {
        final String actualPluralizedWord = pluralizer.pluralize("book");

        assertThat(actualPluralizedWord).isEqualTo("books");
    }

    @Test
    public void pluralizerAppendsAnSToTheEndOfTheSingularWord2() {
        final String actualPluralizedWord = pluralizer.pluralize("chair");

        assertThat(actualPluralizedWord).isEqualTo("chairs");
    }

    @Test
    public void pluralizerDoesNotChangeCase() {
        final String actualPluralizedWord = pluralizer.pluralize("Book");

        assertThat(actualPluralizedWord).isEqualTo("Books");
    }

    @Test
    public void shouldPluralizeAnIrregularWord() {
        assertThat(pluralizer.pluralize("fish")).isEqualTo("fish");
    }

    @Test
    public void shouldPluralizeAnIrregularWord2() {
        assertThat(pluralizer.pluralize("fish")).isEqualTo("fish");
        assertThat(pluralizer.pluralize("sheep")).isEqualTo("sheep");
    }

}
