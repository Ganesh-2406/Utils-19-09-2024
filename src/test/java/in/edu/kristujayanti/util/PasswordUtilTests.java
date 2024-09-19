package in.edu.kristujayanti.util;

import org.junit.Assert;
import org.junit.Test;
import java.util.regex.*;

public class PasswordUtilTests {
    @Test
    public void generateRandomPasswordTest() {
        int length = 8;
        String randomPassword = PasswordUtil.generateRandomPassword(length);

        // Regex to check if the password contains:
        // - At least one digit
        // - At least one lowercase letter
        // - At least one uppercase letter
        // - At least one special character
        // - No whitespace
        // - Minimum length specified
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#$%^&*])"
                + "(?=\\S+$).{%d,}$".formatted(length);

        // Compile the regex
        Pattern pattern = Pattern.compile(regex);

        // Match the generated password against the regex
        Matcher matcher = pattern.matcher(randomPassword);

        // Print the generated password, its length, and if it satisfies the conditions
        System.out.println("Generated Password: " + randomPassword);
        System.out.println("Length: " + randomPassword.length());
        boolean passwordMatchesConditions = matcher.matches();
        System.out.println("Password Satisfies Conditions: " + passwordMatchesConditions);

        Assert.assertTrue("Generated password does not meet the required conditions.", passwordMatchesConditions);
    }
}
