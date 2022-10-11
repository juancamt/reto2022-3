package proyectoReto3.reto3.service;

import org.springframework.stereotype.Service;
import proyectoReto3.reto3.entities.Admin;
import proyectoReto3.reto3.repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private AdminRepository adminRepository;
    public List<Admin>getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin>getAdmin(int idAdmin){
        return adminRepository.getAdmin(idAdmin);
    }
    public Admin save (Admin a){
        if(a.getIdAdmin()==null){
            return adminRepository.save(a);
        }else{
            Optional<Admin> d = adminRepository.getAdmin(a.getIdAdmin());
            if (d.isPresent()){
                return a;
            }else {
                return adminRepository.save(a);
            }
        }
    }
}
