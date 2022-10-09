package proyectoReto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoReto3.reto3.entities.Partyroom;
import proyectoReto3.reto3.repository.PartyroomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PartyroomService {

    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom>getAll(){
        return partyroomRepository.getAll();
    }

    public Optional<Partyroom> getPartytoom(int id){
        return partyroomRepository.getPartyroom(id);
    }

    public Partyroom save(Partyroom p){
        if(p.getId()==null){
            return partyroomRepository.save(p);
        }else {
            Optional<Partyroom> e =partyroomRepository.getPartyroom(p.getId());
            if(e.isEmpty()){
                return p;
            }else{
                return partyroomRepository.save(p);
            }
        }
    }
}
