package lt.e2projects.rental.api.services.product;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lt.e2projects.rental.api.exceptions.ProductNotFoundException;
import lt.e2projects.rental.api.mappers.EntityMapper;
import lt.e2projects.rental.api.models.Product;
import lt.e2projects.rental.api.models.ProductInfo;
import lt.e2projects.rental.api.repositories.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final EntityMapper entityMapper;

    @Override
    @Cacheable("products")
    public List<Product> getProducts() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toProduct)
                .toList();
    }

    @Override
    @SneakyThrows
    @Cacheable(
            value = "productInfo",
            key = "#id",
            sync = true
    )
    public ProductInfo getProductInfo(Long id) {
        return repository.findById(id)
                .map(entityMapper::toProductInfo)
                .orElseThrow(ProductNotFoundException::new);
    }
}
