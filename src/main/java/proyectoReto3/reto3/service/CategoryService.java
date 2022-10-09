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

    public Category save(Category e){
        if(e.getId()==null){
            return categoryRepository.save(e);
        }else {
            Optional<Category> c = categoryRepository.getCategory(e.getId());
            if(c.isEmpty()){
                return e;
            }else{
                return categoryRepository.save(e);
            }
        }
    }
}
