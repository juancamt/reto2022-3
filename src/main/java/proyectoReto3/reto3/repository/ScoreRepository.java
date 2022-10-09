package proyectoReto3.reto3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import proyectoReto3.reto3.entities.Score;
import proyectoReto3.reto3.repository.CrudRepository.ScoreCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired

    private ScoreCrudRepository scoreCrudRepository;
    public List<Score>getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int idScore){
        return scoreCrudRepository.findById(idScore);
    }
    public Score save (Score c){
        return scoreCrudRepository.save(c);
    }
    public void delete(Score c){
        scoreCrudRepository.delete(c);
    }


}
