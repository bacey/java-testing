
import java.util.Map;

public class Pluralizer {

    private final Map<String, String> dictionaryOfIrregularPlurals;

    public Pluralizer(final Map<String, String> dictionaryOfIrregularPlurals) {
        this.dictionaryOfIrregularPlurals = dictionaryOfIrregularPlurals;
    }

    public String pluralize(final String singularNoun) {
        final boolean singularNounHasIrregularPlural = dictionaryOfIrregularPlurals.containsKey(singularNoun);

        if (singularNounHasIrregularPlural) {
            final String irregularPlural = dictionaryOfIrregularPlurals.get(singularNoun);
            return irregularPlural;
        } else {
            final String regularPlural = singularNoun + "s";
            return regularPlural;
        }
    }
}
