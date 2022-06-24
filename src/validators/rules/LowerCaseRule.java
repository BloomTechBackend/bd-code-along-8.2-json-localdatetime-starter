package validators.rules;

public class LowerCaseRule implements Rule {
    @Override
    public boolean isValid(String value) {
        for (char v : value.toCharArray()) {
            if (Character.isLowerCase(v)) {
                return true;
            }
        }
        return false;
    }
}
