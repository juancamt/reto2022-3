package proyectoReto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoReto3.reto3.entities.Score;
import proyectoReto3.reto3.repository.ScoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServise {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score>getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int idScore){
        return scoreRepository.getScore(idScore);
    }
    public Score save (Score s){
        if (s.getIdScore()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> c = scoreRepository.getScore(s.getIdScore());
            if (c.isEmpty()){
                return s;
            }else {
                return scoreRepository.save(s);
            }
        }
    }
}
