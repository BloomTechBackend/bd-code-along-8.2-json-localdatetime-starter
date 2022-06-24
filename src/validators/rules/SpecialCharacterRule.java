package validators.rules;

public class SpecialCharacterRule implements Rule {
    @Override
    public boolean isValid(String value) {
        for (char v : value.toCharArray()) {
            if (!Character.isLetterOrDigit(v)) {
                return true;
            }
        }
        return false;
    }
}
