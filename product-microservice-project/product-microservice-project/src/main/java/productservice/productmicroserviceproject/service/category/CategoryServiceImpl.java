package productservice.productmicroserviceproject.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productservice.productmicroserviceproject.entity.Category;
import productservice.productmicroserviceproject.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{


    @Autowired
    CategoryRepository categoryRepository;



    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return (Category) categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }
}
