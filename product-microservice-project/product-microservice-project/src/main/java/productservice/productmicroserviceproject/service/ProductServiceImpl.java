package productservice.productmicroserviceproject.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import productservice.productmicroserviceproject.entity.Category;
import productservice.productmicroserviceproject.entity.ProductEntity;
import productservice.productmicroserviceproject.mapper.ProductMapper;
import productservice.productmicroserviceproject.models.Product;
import productservice.productmicroserviceproject.repository.CategoryRepository;
import productservice.productmicroserviceproject.repository.ProductRepository;


import java.util.List;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public List<ProductEntity> findAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    @Override
    public ProductEntity findById(Long id) {
        return (ProductEntity) productRepository.findById(id).orElse(null);
    }






    @Override
    public ProductEntity save(ProductEntity product) {



        Category actualCategory = verifyCategory(product);



        ProductEntity productToSave = new ProductEntity();
        ProductEntity existingProduct = productRepository.findByCode(product.getCode());

        if (existingProduct!=null){
            throw new RuntimeException("Product already exist ");
        } else {



            productToSave.setProductId(product.getProductId());
            productToSave.setPrice(product.getPrice());
            productToSave.setDescription(product.getDescription());
            productToSave.setName(product.getName());
            productToSave.setCode(product.getCode());
            productToSave.setCost(product.getCost());
            productToSave.setAvailable(product.isAvailable());
            productToSave.setStock(product.getStock());
            productToSave.setMinStock(product.getMinStock());
            productToSave.setQuantityToBuy(product.getQuantityToBuy());
            productToSave.setCategory(actualCategory);

            Product productToPublish = productMapper.entityToModel(productToSave);


        }

        return productRepository.save(productToSave);

    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductEntity findProductByCode(String code) {
        return productRepository.findByCode(code);
    }

    @Override
    public ProductEntity updateProduct(String code, ProductEntity product) {

            ProductEntity existingProduct = productRepository.findByCode(code);
            Category actualCategory = verifyCategory(product);



            if (existingProduct == null) {
                throw new RuntimeException("Product does exist ");
            }
            else {

                existingProduct.setPrice(product.getPrice());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setName(product.getName());
                existingProduct.setCode(product.getCode());
                existingProduct.setAvailable(product.isAvailable());
                existingProduct.setStock(product.getStock());
                existingProduct.setQuantityToBuy(product.getQuantityToBuy());
                existingProduct.setCost(product.getCost());
                existingProduct.setMinStock(product.getMinStock());
                existingProduct.setCategory(actualCategory);

                log.info("productUpdated is "+existingProduct);
                productRepository.save(existingProduct);
            }

            return existingProduct;

    }


    public Category verifyCategory(ProductEntity product){

        Category actualCategory = Category.builder().build();
        Category existingCategory = categoryRepository.findByName(product.getCategory().getName());
        String productInitialCode = product.getCode().substring(0, 1);

        if (existingCategory!=null){
            actualCategory = existingCategory;
            if (!String.valueOf(existingCategory.getId()).equals(productInitialCode)){
                throw new RuntimeException("Product does not fit Category ");
            }
        } else {
            throw new RuntimeException("Category does not exist ");
        }

        return actualCategory;

    }







}
