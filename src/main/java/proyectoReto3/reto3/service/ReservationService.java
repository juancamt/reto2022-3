package proyectoReto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoReto3.reto3.entities.Reservation;
import proyectoReto3.reto3.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation>getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation c){
        if(c.getIdReservation()==null){
            return reservationRepository.save(c);
        }else {
            Optional<Reservation> e = reservationRepository.getReservation(c.getIdReservation());
            if(e.isEmpty()){
                return c;
            }else{
                return reservationRepository.save(c);
            }
        }
    }
}
