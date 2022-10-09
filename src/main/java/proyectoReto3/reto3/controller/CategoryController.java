package proyectoReto3.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectoReto3.reto3.entities.Category;
import proyectoReto3.reto3.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/Category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category>  getALl(){
        return  categoryService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
    }
}
