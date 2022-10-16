package proyectoReto3.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectoReto3.reto3.entities.Partyroom;
import proyectoReto3.reto3.service.PartyroomService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Partyroom")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class PartyroomController {
    @Autowired
    private PartyroomService partyroomService;

    @GetMapping("/all")
    public List<Partyroom>  getALl(){
        return  partyroomService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Partyroom> getPartyroom(@PathVariable("id") int idPartyroom){
        return partyroomService.getPartytoom(idPartyroom);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom p){
        return partyroomService.save(p);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom update(@RequestBody Partyroom partyroom){
        return partyroomService.update(partyroom);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int id){
        return partyroomService.deletePartyroom(id);
    }
}
