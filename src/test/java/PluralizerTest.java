import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class PluralizerTest {

    @Test
    public void pluralizerAppendsAnSToTheEndOfTheSingularWord() {
        testPluralizerWith("book", "books");
    }

    @Test
    public void pluralizerDoesNotChangeCase() {
        testPluralizerWith("Book", "Books");
    }

    @Test
    public void shouldPluralizeAnIrregularWord() {
        final Map<String, String> dictionaryOfIrregularPlurals = ImmutableMap.of("fish", "fish");

        testPluralizerWith("fish", "fish", dictionaryOfIrregularPlurals);
    }

    private void testPluralizerWith(final String singularWord, final String expectedPluralWord) {
        final Map<String, String> emptyDictionaryOfIrregularPlurals = Collections.emptyMap();

        testPluralizerWith(singularWord, expectedPluralWord, emptyDictionaryOfIrregularPlurals);
    }

    private void testPluralizerWith(final String singularWord, final String expectedPluralWord, final Map<String, String> dictionaryOfIrregularPlurals) {
        final Pluralizer pluralizer = new Pluralizer(dictionaryOfIrregularPlurals);

        final String actualPluralWord = pluralizer.pluralize(singularWord);

        assertThat(actualPluralWord).isEqualTo(expectedPluralWord);
    }

}
