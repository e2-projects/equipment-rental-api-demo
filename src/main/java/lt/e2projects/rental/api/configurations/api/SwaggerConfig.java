package lt.e2projects.rental.api.configurations.api;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.rental.api.configurations.api.properties.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableOpenApi
@EnableConfigurationProperties(SwaggerProperties.class)
class SwaggerConfig {

    private final SwaggerProperties properties;

    public SwaggerConfig(SwaggerProperties properties) {
        this.properties = properties;
    }

    @Bean
    Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .securitySchemes(basicScheme())
                .directModelSubstitute(LocalDateTime.class, String.class)
                .groupName(properties.title())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder.builder()
                .docExpansion(DocExpansion.NONE)
                .operationsSorter(OperationsSorter.ALPHA)
                .defaultModelRendering(ModelRendering.MODEL)
                .displayRequestDuration(true)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .version(properties.version())
                .title(properties.title())
                .description(properties.description())
                .contact(new Contact(properties.contactName(), properties.url(), properties.contact()))
                .build();
    }

    private List<SecurityScheme> basicScheme() {
        var schemeList = new ArrayList<SecurityScheme>();
        schemeList.add(new BasicAuth("apiAuth"));
        return schemeList;
    }

}
