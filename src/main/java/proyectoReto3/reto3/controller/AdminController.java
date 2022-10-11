package proyectoReto3.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectoReto3.reto3.entities.Admin;
import proyectoReto3.reto3.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save (@RequestBody Admin a){
        return adminService.save(a);
    }
}
