package lt.e2projects.rental.api.configurations;

import lt.e2projects.rental.api.mappers.EntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    @Bean
    EntityMapper entityMapper() {
        return EntityMapper.instance;
    }

}
