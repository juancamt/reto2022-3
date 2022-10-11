package proyectoReto3.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectoReto3.reto3.entities.Partyroom;
import proyectoReto3.reto3.service.PartyroomService;

import java.util.List;

@RestController
@RequestMapping("/api/Partyroom")

public class PartyroomController {
    @Autowired
    private PartyroomService partyroomService;

    @GetMapping("/all")
    public List<Partyroom>  getALl(){
        return  partyroomService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom p){
        return partyroomService.save(p);
    }
}
