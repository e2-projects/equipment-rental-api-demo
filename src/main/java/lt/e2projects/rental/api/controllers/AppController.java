package lt.e2projects.rental.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = {"Test"})
@RestController
@RequestMapping("/test")
public class AppController {

    @ApiOperation(
            value = "Get true",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    boolean getTested() {
        return true;
    }

}
