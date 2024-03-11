package collection.exercise3;

import java.util.regex.Pattern;

public interface Validator {
    static boolean isValidGender(String input) {
        return input.equalsIgnoreCase("Male") || input.equalsIgnoreCase("Female");
    }

    static boolean isValidDateOfBirth(String input) {
        return Pattern.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}", input);
    }

    static boolean isValidPhoneNumber(String input) {
        return Pattern.matches("\\d{10,11}", input);
    }

    static boolean isValidEducationLevel(String input) {
        return input.equalsIgnoreCase("Intermediate") ||
                input.equalsIgnoreCase("College") ||
                input.equalsIgnoreCase("University");
    }
}
