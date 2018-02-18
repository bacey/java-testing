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
    public void pluralizerAppendsAnSToTheEndOfTheSingularNoun() {
        final String actualPluralizedNoun = pluralizer.pluralize("book");

        assertThat(actualPluralizedNoun).isEqualTo("books");
    }

    @Test
    public void pluralizerAppendsAnSToTheEndOfTheSingularNoun2() {
        final String actualPluralizedNoun = pluralizer.pluralize("chair");

        assertThat(actualPluralizedNoun).isEqualTo("chairs");
    }

    @Test
    public void pluralizerDoesNotChangeCase() {
        final String actualPluralizedNoun = pluralizer.pluralize("Book");

        assertThat(actualPluralizedNoun).isEqualTo("Books");
    }

    @Test
    public void shouldPluralizeAnIrregularNoun() {
        assertThat(pluralizer.pluralize("fish")).isEqualTo("fish");
    }

    @Test
    public void shouldPluralizeAnIrregularNoun2() {
        assertThat(pluralizer.pluralize("fish")).isEqualTo("fish");
        assertThat(pluralizer.pluralize("sheep")).isEqualTo("sheep");
    }

}
