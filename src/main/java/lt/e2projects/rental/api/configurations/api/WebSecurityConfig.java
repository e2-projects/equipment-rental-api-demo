package lt.e2projects.rental.api.configurations.api;

import lt.e2projects.rental.api.configurations.api.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
class WebSecurityConfig implements WebSecurityCustomizer {

    private final SecurityProperties properties;

    WebSecurityConfig(SecurityProperties properties) {
       this.properties = properties;
    }

    @Override
    public void customize(WebSecurity web) {
        web.ignoring().antMatchers(properties.pathWhitelist().toArray(String[]::new));
    }
}
