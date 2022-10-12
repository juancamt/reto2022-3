package proyectoReto3.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectoReto3.reto3.entities.Score;
import proyectoReto3.reto3.service.ScoreServise;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})

public class ScoreCrontoller {
    @Autowired
    private ScoreServise scoreServise;
    @GetMapping ("/all")
    public List<Score> getAll(){
        return scoreServise.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score s){
        return scoreServise.save(s);
    }
}
