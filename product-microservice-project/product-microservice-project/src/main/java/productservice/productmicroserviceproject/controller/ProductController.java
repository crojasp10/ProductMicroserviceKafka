package productservice.productmicroserviceproject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import productservice.productmicroserviceproject.entity.ProductEntity;
import productservice.productmicroserviceproject.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/getAll")
    public List<ProductEntity> getAll() {
       return productService.findAll();
    }


    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity addProduct(@RequestBody ProductEntity product){
         return productService.save(product);
    }


    @GetMapping("/{code}")
    public ProductEntity getProductByCode(@PathVariable String code) {
        ProductEntity product = productService.findProductByCode(code);
        if (product != null) {
            return product;
        } else {
            throw new RuntimeException("Product does not exist ");
        }
    }


    @PatchMapping("/{code}")
    public ProductEntity partialUpdateUser(@PathVariable String code, @RequestBody ProductEntity product) {

        ProductEntity updatedUser = productService.updateProduct(code, product);

        if (updatedUser != null) {
            return updatedUser;
        } else {
            throw new RuntimeException("Product does not exist");
        }
    }



}
