package lt.e2projects.rental.api.controllers.products;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.rental.api.models.Product;
import lt.e2projects.rental.api.models.ProductInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
interface ProductEndpoints {

    @ApiOperation(
            value = "Get available products",
            notes = "Get products which is available",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Product> getProducts();

    @ApiOperation(
            value = "Get product details",
            notes = "Get product details by id",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @GetMapping(path = "/info/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProductInfo getProductInfo(@PathVariable Long id);

}
