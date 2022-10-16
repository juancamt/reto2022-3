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
            if(c.isPresent()){
                return e;
            }else{
                return clientRepository.save(e);
            }
        }
    }
    public Client update(Client client){
        if (client.getIdClient()!=null){
            Optional<Client> a = clientRepository.getClient(client.getIdClient());
            if(a.isPresent()){
                if (client.getName()!=null){
                    a.get().setName(client.getName());
                }
                if (client.getEmail()!=null){
                    a.get().setEmail(client.getEmail());
                }
                if (client.getAge()!=null) {
                    a.get().setAge(client.getAge());
                }
                if (client.getPassword()!=null) {
                    a.get().setPassword(client.getPassword());
                }
                clientRepository.save(a.get());
                return a.get();
            }
        }
        return client;
    }
    public boolean deleteClient(int id){
        boolean c = getClient(id).map(client -> {
            clientRepository.delete(client);
            return  true;
        }).orElse(false);
        return c;
    }
}
