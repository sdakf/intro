package simpleapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CalculatorService {


    @GetMapping(value = "/calc")
    public String calculate(@RequestParam(required = false) String input, Map<String, Object> model) {
        if (input != null && !input.isEmpty()) {
            String[] split = input.split(" ");
            model.put("result", "Twój wynik to: " + calculate(Integer.valueOf(split[0]), Integer.valueOf(split[2]), split[1]));
        }
        return "calcPage";
    }


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
