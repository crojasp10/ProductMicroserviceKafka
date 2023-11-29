package productservice.productmicroserviceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productservice.productmicroserviceproject.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository <ProductEntity,Long> {

    public ProductEntity findByCode(String code);


}
