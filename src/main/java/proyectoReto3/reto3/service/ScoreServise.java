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
            if (c.isPresent()){
                return s;
            }else {
                return scoreRepository.save(s);
            }
        }
    }
    public Score update(Score score){
        if (score.getIdScore()!=null){
            Optional<Score> a = scoreRepository.getScore(score.getIdScore());
            if(a.isPresent()){
                if (score.getMessageText()!=null){
                    a.get().setMessageText(score.getMessageText());
                }
                if (score.getStars()!=null){
                    a.get().setStars(score.getStars());
                }
                scoreRepository.save(a.get());
                return a.get();
            }else {
                return score;
            }
        }else {
            return score;
        }
    }
    public boolean deleteScore(int id){
        boolean d = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return  true;
        }).orElse(false);
        return d;
    }
}
