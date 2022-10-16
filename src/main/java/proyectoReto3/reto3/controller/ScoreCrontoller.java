package proyectoReto3.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectoReto3.reto3.entities.Score;
import proyectoReto3.reto3.service.ScoreServise;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ScoreCrontoller {
    @Autowired
    private ScoreServise scoreServise;
    @GetMapping ("/all")
    public List<Score> getAll(){
        return scoreServise.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int idScore){
        return scoreServise.getScore(idScore);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score s){
        return scoreServise.save(s);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return scoreServise.update(score);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int id){
        return scoreServise.deleteScore(id);
    }
}
