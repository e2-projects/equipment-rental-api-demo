package lt.e2projects.rental.api.services.product;

import lt.e2projects.rental.api.models.Product;
import lt.e2projects.rental.api.models.ProductInfo;

import java.util.List;

public interface ProductService {

    /**
     * Get all available products
     * @return List<Product>
     * @see Product
     * */
    List<Product> getProducts();

    /**
     * Get product information by product ID
     * @param id -  product ID (Long)
     * @return ProductInfo
     * @see ProductInfo
     * */
    ProductInfo getProductInfo(Long id);
}
