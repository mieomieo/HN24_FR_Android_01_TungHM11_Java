package collection.exercise3;

import java.util.regex.Pattern;

public interface Validator {
    boolean isValid(String input);

    class GenderValidator implements Validator {
        @Override
        public boolean isValid(String input) {
            return input.equalsIgnoreCase("Male") || input.equalsIgnoreCase("Female");
        }
    }

    class DateOfBirthValidator implements Validator {
        @Override
        public boolean isValid(String input) {
            return Pattern.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}", input);
        }
    }

    class PhoneNumberValidator implements Validator {
        @Override
        public boolean isValid(String input) {
            return Pattern.matches("\\d{10,11}", input);
        }
    }

    class EducationLevelValidator implements Validator {
        @Override
        public boolean isValid(String input) {
            return input.equalsIgnoreCase("Intermediate") ||
                    input.equalsIgnoreCase("College") ||
                    input.equalsIgnoreCase("University");
        }
    }
}
