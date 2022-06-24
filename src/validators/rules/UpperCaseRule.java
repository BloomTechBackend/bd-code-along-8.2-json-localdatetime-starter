package validators.rules;

public class UpperCaseRule implements Rule {
    @Override
    public boolean isValid(String value) {
        for (char v : value.toCharArray()) {
            if (Character.isUpperCase(v)) {
                return true;
            }
        }
        return false;
    }
}
