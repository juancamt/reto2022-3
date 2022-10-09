package proyectoReto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoReto3.reto3.entities.Client;
import proyectoReto3.reto3.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client>getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client e){
        if(e.getIdClient()==null){
            return clientRepository.save(e);
        }else {
            Optional<Client> c = clientRepository.getClient(e.getIdClient());
            if(c.isEmpty()){
                return e;
            }else{
                return clientRepository.save(e);
            }
        }
    }
}
