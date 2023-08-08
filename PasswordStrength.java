import java.util.regex.*;

public class PasswordStrength {
    public static String checkPasswordStrength(String password) {
        int score = 0;

        // Check for length
        if (password.length() >= 8) {
            score++;
        }

        // Check for lower case letters
        if (Pattern.compile("[a-z]").matcher(password).find()) {
            score++;
        }

        // Check for upper case letters
        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            score++;
        }

        // Check for digits
        if (Pattern.compile("[0-9]").matcher(password).find()) {
            score++;
        }

        // Check for special characters
        if (Pattern.compile("[!@#$%^&*()_+=-`~?;:'<>.,|]").matcher(password).find()) {
            score++;
        }
        
        if (Pattern.compile("ABC").matcher(password).find()) {
            return "Commonly used";
        }
        
        if (Pattern.compile("abc").matcher(password).find()) {
            return "Commonly used";
        }
        
        if (Pattern.compile("123").matcher(password).find()) {
            return "Commonly used";
        }

        // Evaluate score
        if (score < 3) {
            return "Weak";
        } 
        
        else if (score < 5) {
            return "Moderate";
        }
        
        else {
            return "Strong";
        }
        
    }
}
