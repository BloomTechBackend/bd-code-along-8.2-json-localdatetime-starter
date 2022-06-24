package validators.rules;

public class NumberRule implements Rule {
    @Override
    public boolean isValid(String value) {
        for (char v : value.toCharArray()) {
            if (Character.isDigit(v)) {
                return true;
            }
        }
        return false;
    }
}
