package productservice.productmicroserviceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import productservice.productmicroserviceproject.entity.Category;
import productservice.productmicroserviceproject.service.category.CategoryService;


@RestController
public class CategoryController {



    @Autowired
    CategoryService categoryService;

    @PostMapping("/createCategory")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addProduct(@RequestBody Category category){
        return categoryService.save(category);
    }




}
