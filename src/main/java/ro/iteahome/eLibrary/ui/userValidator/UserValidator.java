package ro.iteahome.eLibrary.ui.userValidator;

import ro.iteahome.eLibrary.exception.LibraryInvalidUserInputDateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public boolean validateUserCredentials(String name, String password)  throws LibraryInvalidUserInputDateException {

        boolean valid = true;

        Pattern patternName, patternPass;
        Matcher matcherName, matcherPass;

        final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
        final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";

        patternName = Pattern.compile(USERNAME_PATTERN);
        matcherName = patternName.matcher(name);
        boolean matchesName = matcherName.matches();

        patternPass = Pattern.compile(PASSWORD_PATTERN);
        matcherPass = patternPass.matcher(password);
        boolean matchesPass = matcherPass.matches();

        if (matchesName == false)
            throw new LibraryInvalidUserInputDateException("Incorect user name format : 3-15 characters / only a-z, 0-9");
        else if (matchesPass == false)
            throw new LibraryInvalidUserInputDateException("Incorect password format :  at least one lowercase letter, digit, special char, capital letter, 6-16 length");

            /*
            (?=.*[a-z])     : This matches the presence of at least one lowercase letter.
            (?=.*d)         : This matches the presence of at least one digit i.e. 0-9.
            (?=.*[@#$%])    : This matches the presence of at least one special character.
            ((?=.*[A-Z])    : This matches the presence of at least one capital letter.
            {6,16}          : This limits the length of password from minimum 6 letters to maximum 16 letters.
             */
        return valid;

    }
}
