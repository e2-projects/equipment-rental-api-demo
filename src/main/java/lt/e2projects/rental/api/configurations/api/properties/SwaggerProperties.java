package lt.e2projects.rental.api.configurations.api.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("api.swagger")
public record SwaggerProperties(String version,
                                String title,
                                String description,
                                String contactName,
                                String url,
                                String contact) {
}
