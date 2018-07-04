package simpleapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WelcomeController {
    @GetMapping(value = "/")
    public String index(Map<String, Object> model) {
        model.put("welcome", "HELLO WORLD!");
        return "index";
    }

    @GetMapping(value = "/{value}")
    public String index(Map<String, Object> model, @PathVariable String value) {
        model.put("welcome", value);
        return "index";
    }
}
