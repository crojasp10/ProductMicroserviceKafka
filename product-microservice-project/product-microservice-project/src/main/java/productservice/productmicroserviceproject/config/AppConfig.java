package productservice.productmicroserviceproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import productservice.productmicroserviceproject.entity.ProductEntity;
import productservice.productmicroserviceproject.mapper.ProductMapper;
import productservice.productmicroserviceproject.models.Category;
import productservice.productmicroserviceproject.models.Product;

@Configuration
public class AppConfig {

    private final String clientRest = "clientRest";


    @Bean(clientRest)
    public RestTemplate registrarRestTemplate() {
        return new RestTemplate();
    }


    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper() {
            @Override
            public Product entityToModel(ProductEntity entity) {
                if (entity == null) {
                    return null;
                }

                Category category = new Category();
                category.setName(entity.getCategory().getName());

                Product product = new Product();
                product.setCode(entity.getCode());
                product.setName(entity.getName());
                product.setProductId(entity.getProductId());
                product.setPrice(entity.getPrice());
                product.setAvailable(entity.isAvailable());
                product.setStock(entity.getStock());
                product.setDescription(entity.getDescription());
                product.setCategory(category);
                return product;


            }

            @Override
            public ProductEntity modelToEntity(Product model) {
                return null;
            }
        }; // or create the bean instance as appropriate
    }


}
