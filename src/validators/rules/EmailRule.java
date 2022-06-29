package validators.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRule implements Rule {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean isValid(String value) {
        //TODO Step 3 - implement the regex for email
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value);
        return matcher.find();
    }
}
