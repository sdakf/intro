import org.springframework.stereotype.Controller;

public class CalculatorService {

    public static String calculate(int a, int b, String operation) {
        try {
            if (operation.equals("+")) {
                return String.valueOf(a + b);
            } else if (operation.equals("-")) {
                return String.valueOf(a - b);
            } else if (operation.equals("/")) {
                return String.valueOf(a / b);
            } else if (operation.equals("*")) {
                return String.valueOf(a * b);
            }
        } catch (Exception e) {
            return "Błąd";
        }
        return "Zły znak";
    }
}
