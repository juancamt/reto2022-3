package proyectoReto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoReto3.reto3.entities.Category;
import proyectoReto3.reto3.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category>getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else {
            Optional<Category> c = categoryRepository.getCategory(category.getId());
            if(c.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }
    public Category update(Category category){
        if (category.getId()!=null){
            Optional<Category> a = categoryRepository.getCategory(category.getId());
            if(a.isPresent()){
                if (category.getDescription()!=null){
                    a.get().setDescription(category.getDescription());
                }
                if (category.getName()!=null){
                    a.get().setName(category.getName());
                }
                return categoryRepository.save(a.get());
            }
        }
        return category;
    }
    public boolean deleteCategory(int id){
        boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return  true;
        }).orElse(false);
        return d;
    }
}
