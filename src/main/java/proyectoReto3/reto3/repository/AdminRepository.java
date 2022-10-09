package proyectoReto3.reto3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import proyectoReto3.reto3.entities.Admin;
import proyectoReto3.reto3.repository.CrudRepository.AdminCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired

    private AdminCrudRepository adminCrudRepository;

    public List<Admin>getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin>getAdmin(int idAdmin){
        return adminCrudRepository.findById(idAdmin);
    }
    public Admin save (Admin a){
        return adminCrudRepository.save(a);
    }
    public void delete (Admin a){
        adminCrudRepository.delete(a);
    }
}
