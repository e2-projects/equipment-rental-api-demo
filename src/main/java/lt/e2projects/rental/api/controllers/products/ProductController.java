package lt.e2projects.rental.api.controllers.products;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lt.e2projects.rental.api.models.Product;
import lt.e2projects.rental.api.models.ProductInfo;
import lt.e2projects.rental.api.services.product.ProductService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Api(tags = {"Products"})
@Controller
@RequiredArgsConstructor
class ProductController implements ProductEndpoints {

    private final ProductService service;

    @Override
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @Override
    public ProductInfo getProductInfo(Long id) {
        return service.getProductInfo(id);
    }
}
