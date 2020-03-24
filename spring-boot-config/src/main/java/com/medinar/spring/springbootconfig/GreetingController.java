package com.medinar.spring.springbootconfig;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rommelmedina
 */
@RestController
public class GreetingController {

    @Value("${my.greeting: default value}")
    private String greeting;

    @Value("${app.description}")
    private String appDescription;

    @Value("some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> myListValues;

    @Value("#{${db.values}}")
    private Map<String, String> dbValues;

    @Autowired
    DbConfig dbConfig;

    @Autowired
    Environment env;

    @GetMapping("/greeting")
    public String getGreeting() {
        return greeting + "! | "
                + appDescription + " | "
                + staticMessage + " | "
                + myListValues + " | "
                + dbValues + " | "
                + dbConfig.toString();
    }

    @GetMapping("/envdetails")
    public String getEnvDetails() {
        return env.toString();
    }

}
