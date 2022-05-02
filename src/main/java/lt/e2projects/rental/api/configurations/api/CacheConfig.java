package lt.e2projects.rental.api.configurations.api;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lt.e2projects.rental.api.configurations.api.properties.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@EnableConfigurationProperties(CacheProperties.class)
class CacheConfig {

    private final CacheProperties properties;

    public CacheConfig(CacheProperties properties) {
        this.properties = properties;
    }

    @Bean
    HazelcastInstance hazelcastInstance() {
        return Hazelcast.newHazelcastInstance(config());
    }

    @Bean
    Config config() {
        Config config = new Config();
        config.setInstanceName("hazelcast");

        EvictionConfig evictionConfig = new EvictionConfig();
        evictionConfig.setEvictionPolicy(EvictionPolicy.LRU);
        evictionConfig.setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE);

        properties.timeToLive().forEach(ttl ->
            config.addMapConfig(
                    new MapConfig(ttl.name())
                            .setTimeToLiveSeconds(ttl.seconds())
                            .setBackupCount(2)
                            .setEvictionConfig(evictionConfig)
            )
        );

        return config;
    }

}
