package final_exam.exercise4;

import java.util.regex.Pattern;

public interface Validator {
    static boolean isValidPhoneNumber(String input) {
        return Pattern.matches("\\d{10,11}", input);
    }

}
