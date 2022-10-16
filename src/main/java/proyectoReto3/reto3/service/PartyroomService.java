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
            if(e.isPresent()){
                return p;
            }else{
                return partyroomRepository.save(p);
            }
        }
    }
    public Partyroom update(Partyroom partyroom){
        if (partyroom.getId()!=null){
            Optional<Partyroom> a = partyroomRepository.getPartyroom(partyroom.getId());
            if(a.isPresent()){
                if (partyroom.getName()!=null){
                    a.get().setName(partyroom.getName());
                }
                if (partyroom.getOwner()!=null){
                    a.get().setOwner(partyroom.getOwner());
                }
                if (partyroom.getCapacity()!=null) {
                    a.get().setCapacity(partyroom.getCapacity());
                }
                if (partyroom.getDescription()!=null) {
                    a.get().setDescription(partyroom.getDescription());
                }
                partyroomRepository.save(a.get());
                return a.get();
            }
        }
        return partyroom;
    }
    public boolean deletePartyroom(int id){
        boolean d = getPartytoom(id).map(partyroom -> {
            partyroomRepository.delete(partyroom);
            return  true;
        }).orElse(false);
        return d;
    }
}
