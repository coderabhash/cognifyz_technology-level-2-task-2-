import java.util.*;

public class PasswordStrengthChecker {


    public static String checkPasswordStrength(String password) {
        
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean isLongEnough = password.length() >= 8;

        
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        
        int criteriaMet = 0;
        if (isLongEnough) criteriaMet++;
        if (hasUpperCase) criteriaMet++;
        if (hasLowerCase) criteriaMet++;
        if (hasDigit) criteriaMet++;
        if (hasSpecialChar) criteriaMet++;

    
        if (criteriaMet == 5) {
            return "Strong";
        } else if (criteriaMet >= 3) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }

    public static void main(String[] args) {
        
        Scanner Sc = new Scanner(System.in);

    
        System.out.print("Enter a password to check its strength :");
        String password = Sc.nextLine();

        
        String strength = checkPasswordStrength(password);

        
        System.out.println("Password strength: " + strength);
    }
}

