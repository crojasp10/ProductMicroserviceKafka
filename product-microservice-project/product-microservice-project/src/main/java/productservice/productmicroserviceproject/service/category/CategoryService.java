package productservice.productmicroserviceproject.service.category;

import productservice.productmicroserviceproject.entity.Category;

import java.util.List;

public interface CategoryService {


    public List<Category> findAll();
    public Category findById(Long id);
    public Category save (Category category);
    public void deleteById (Long id);

    public Category findByName(String categoryName);



}
