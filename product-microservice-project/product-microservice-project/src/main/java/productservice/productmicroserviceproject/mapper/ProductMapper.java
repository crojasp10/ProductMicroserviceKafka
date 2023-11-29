package productservice.productmicroserviceproject.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.factory.Mappers;
import productservice.productmicroserviceproject.entity.ProductEntity;
import productservice.productmicroserviceproject.models.Product;

@Mapper(config = MapperConfig.class)
public interface ProductMapper {


    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product entityToModel(ProductEntity entity);

    ProductEntity modelToEntity(Product model);





}