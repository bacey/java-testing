
import java.util.Collections;
import java.util.Map;

public class Pluralizer {

    private final Map<String, String> dictionaryOfIrregularPlurals;

    public Pluralizer() {
        // this(Collections.emptyMap());
        this.dictionaryOfIrregularPlurals = Collections.emptyMap();
    }

    public Pluralizer(final Map<String, String> dictionaryOfIrregularPlurals) {
        this.dictionaryOfIrregularPlurals = dictionaryOfIrregularPlurals;
    }

    public String pluralize(final String singularWord) {
        final boolean singularWordHasIrregularPlural = dictionaryOfIrregularPlurals.containsKey(singularWord);

        if (singularWordHasIrregularPlural) {
            final String irregularPlural = dictionaryOfIrregularPlurals.get(singularWord);
            return irregularPlural;
        } else {
            final String regularPlural = singularWord + "s";
            return regularPlural;
        }
    }
}
