package net.cmderobertis.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HumanRoutes {
    @RequestMapping("")
    StringBuilder hello(@RequestParam(value = "first_name", required = false) String firstName, @RequestParam(value = "last_name", required = false) String lastName, @RequestParam(value = "times", required = false) String times) {
        String response = "Hello";
        if (firstName != null) {
            response += " " + firstName;
        }
        if (lastName != null) {
            response += " " + lastName;
        }
        if (firstName == null && lastName == null) {
            response += " Human";
        }
        StringBuilder sb = new StringBuilder(response);
        if (times != null) {
            try {
                int num = Integer.parseInt(times);
                for (int i = 1; i < num; i++) {
                    sb.append(" ").append(response);
                }
            } catch (NumberFormatException e) {
                return sb;
            }
        }
        return sb;
    }

}
