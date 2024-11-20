
package Interfaz;


public class Validador {

    public static boolean isPositiveNumber(int number) {
        return number > 0;
    }

    
    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".");
    }

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }
}

