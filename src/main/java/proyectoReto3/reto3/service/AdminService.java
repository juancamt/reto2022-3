package proyectoReto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoReto3.reto3.entities.Admin;
import proyectoReto3.reto3.repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
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
    public Admin update(Admin admin){
        if (admin.getIdAdmin()!=null){
            Optional<Admin> a = adminRepository.getAdmin(admin.getIdAdmin());
            if(a.isPresent()){
                if (admin.getName()!=null){
                    a.get().setName(admin.getName());
                }
                if (admin.getEmail()!=null){
                    a.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword()!=null){
                    a.get().setPassword(admin.getPassword());
                }
                adminRepository.save(a.get());
                return a.get();
            }else {
                return admin;
            }
        }else {
            return admin;
        }
    }
    public boolean deleteAdmin(int id){
        boolean d = getAdmin(id).map(admin -> {
            adminRepository.delete(admin);
            return  true;
        }).orElse(false);
        return d;
    }
}
