package proyectoReto3.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectoReto3.reto3.entities.Admin;
import proyectoReto3.reto3.service.AdminService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int idAdmin){
        return adminService.getAdmin(idAdmin);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save (@RequestBody Admin a){
        return adminService.save(a);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin){
        return adminService.update(admin);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int id){
        return adminService.deleteAdmin(id);
    }
}
