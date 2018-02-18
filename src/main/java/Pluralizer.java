import java.util.Map;

public class Pluralizer {

    private final Map<String, String> dictionaryOfIrregularPlurals;

    public Pluralizer(final Map<String, String> dictionaryOfIrregularPlurals) {
        this.dictionaryOfIrregularPlurals = dictionaryOfIrregularPlurals;
    }

    public String pluralize(final String singularWord) {
        final boolean singularWordHasAnIrregularPlural = dictionaryOfIrregularPlurals.containsKey(singularWord);

        if (singularWordHasAnIrregularPlural) {
            final String irregularPlural = dictionaryOfIrregularPlurals.get(singularWord);
            return irregularPlural;
        } else {
            final String regularPlural = singularWord + "s";
            return regularPlural;
        }
    }

}
