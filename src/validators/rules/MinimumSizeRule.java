package validators.rules;

public class MinimumSizeRule implements Rule {

    private final int minimumSize;

    public MinimumSizeRule(int minimumSize) {
        this.minimumSize = minimumSize;
    }

    @Override
    public boolean isValid(String value) {
        return value.length() >= minimumSize;
    }
}
