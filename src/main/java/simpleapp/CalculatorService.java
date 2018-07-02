package simpleapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class CalculatorService {


    @GetMapping(value = "/calc")
    public String calculate(@RequestParam(required = false) String input, Map<String, Object> model) {
        if (input != null && !input.isEmpty()) {
            String[] split = input.split(" ");
            String result = calculate(Integer.valueOf(split[0]), Integer.valueOf(split[2]), split[1]);
            model.put("result", "Twój wynik to: " + result);
            saveResultToFile(split[0] + split[1] + split[2] + "=" + result);
            List<String> history = getHistory();
            model.put("history", history);

        }
        return "calcPage";
    }

    private List<String> getHistory() {
        try {
            return Files.readAllLines(Paths.get(this.getClass().getClassLoader().getResource("historia.txt").toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void saveResultToFile(String result) {
        try {
            Files.write(Paths.get(this.getClass().getClassLoader().getResource("historia.txt").toURI()), Arrays.asList(result), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
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
