package lt.e2projects.rental.api.configurations.properties;

import lt.e2projects.rental.api.configurations.properties.models.TimeToLiveItem;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("api.cache")
public record CacheProperties(List<TimeToLiveItem> timeToLive) {
}
