package lt.e2projects.rental.api.mappers;

import lt.e2projects.rental.api.models.Product;
import lt.e2projects.rental.api.models.ProductInfo;
import lt.e2projects.rental.api.repositories.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper instance = Mappers.getMapper(EntityMapper.class);

    @Mapping(source = "title", target = "name")
    @Mapping(source = "rentable", target = "isRentable")
    Product toProduct(ProductEntity entity);

    @Mapping(source = "title", target = "name")
    @Mapping(source = "rentable", target = "isRentable")
    ProductInfo toProductInfo(ProductEntity entity);

}
