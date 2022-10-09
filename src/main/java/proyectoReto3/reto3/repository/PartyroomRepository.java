package proyectoReto3.reto3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import proyectoReto3.reto3.entities.Partyroom;
import proyectoReto3.reto3.repository.CrudRepository.PartyroomCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class PartyroomRepository {

    @Autowired
    private PartyroomCrudRepository partyroomCrudRepository;

    public List<Partyroom>getAll(){
        return (List<Partyroom>) partyroomCrudRepository.findAll();
    }

    public Optional<Partyroom> getPartyroom(int id){
        return partyroomCrudRepository.findById(id);
    }

    public Partyroom save(Partyroom p){
        return partyroomCrudRepository.save(p);
    }

    public void delete(Partyroom p){
        partyroomCrudRepository.delete(p);
    }
}
