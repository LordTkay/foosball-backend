package de.tkay.foosball;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that manages the REST endpoints simple or singular endpoints.
 */
@RestController
public class FoosballController {

    private final ConfigProperties configProperties;

    public FoosballController(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @GetMapping("/version")
    public @ResponseBody String getVersion() {
        return configProperties.getVersion();
    }

}
