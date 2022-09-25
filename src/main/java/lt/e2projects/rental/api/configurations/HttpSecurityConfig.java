package lt.e2projects.rental.api.configurations;

import lt.e2projects.rental.api.configurations.properties.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class HttpSecurityConfig {

    private final SecurityProperties properties;

    public HttpSecurityConfig(SecurityProperties properties) {
        this.properties = properties;
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        var manager = new InMemoryUserDetailsManager();
        // manager.createUser(new User(properties.username(), properties.password(), getGrantedAuthorities()));
        manager.createUser(
                User.builder()
                        .username(properties.username())
                        .password(properties.password())
                        .roles(properties.roles().toArray(String[]::new))
                        .passwordEncoder(passwordEncoder()::encode)
                        .build()
        );
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(properties.pathWhitelist().toArray(String[]::new)).permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private List<GrantedAuthority> getGrantedAuthorities() {
        var grantedAuthorities = new ArrayList<GrantedAuthority>();
        properties.roles().forEach(role ->
                grantedAuthorities.add(new SimpleGrantedAuthority(role))
        );
        return grantedAuthorities;
    }
}
