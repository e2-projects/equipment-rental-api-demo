package lt.e2projects.rental.api.configurations.api.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("api.security")
public record SecurityProperties(String username, String password, List<String> roles, List<String> pathWhitelist) {
}
