package productservice.productmicroserviceproject.service;

import productservice.productmicroserviceproject.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    public List<ProductEntity> findAll();
    public ProductEntity findById(Long id);
    public ProductEntity save (ProductEntity product);
    public void deleteById (Long id);

    public ProductEntity findProductByCode(String code);

    public ProductEntity updateProduct (String code, ProductEntity product);

}
