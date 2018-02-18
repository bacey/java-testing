import java.util.Map;

public class Pluralizer {

    private final Map<String, String> irregularPlurals;

    public Pluralizer(final Map<String, String> irregularPlurals) {
        this.irregularPlurals = irregularPlurals;
    }

    public String pluralize(final String singularWord) {
        final boolean singularWordHasAnIrregularPlural = irregularPlurals.containsKey(singularWord);

        if (singularWordHasAnIrregularPlural) {
            final String irregularPlural = irregularPlurals.get(singularWord);
            return irregularPlural;
        } else {
            final String regularPlural = singularWord + "s";
            return regularPlural;
        }
    }

}
