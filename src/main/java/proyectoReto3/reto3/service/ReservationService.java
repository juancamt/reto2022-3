package proyectoReto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoReto3.reto3.entities.Reservation;
import proyectoReto3.reto3.entities.dtos.CompleteAndCancelled;
import proyectoReto3.reto3.entities.dtos.TotalAndClient;
import proyectoReto3.reto3.repository.ReservationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            if(e.isPresent()){
                return c;
            }else{
                return reservationRepository.save(c);
            }
        }
    }
    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation()!=null){
            Optional<Reservation> a = reservationRepository.getReservation(reservation.getIdReservation());
            if(a.isPresent()){
                if (reservation.getStartDate()!=null){
                    a.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!=null){
                    a.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!=null){
                    a.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(a.get());
                return a.get();
            }else{
                return reservation;
            }
        }else {
            return reservation;
        }
    }
    public boolean deleteReservation(int id){
        boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return  true;
        }).orElse(false);
        return d;
    }

    public  List<Reservation> getReservationBetweenDatesReport(String fechaA,String fechaB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(fechaA);
            b = parser.parse(fechaB);
        }catch (ParseException exception){
            exception.printStackTrace();
        }
        if (a.before(b)){
            return reservationRepository.getReservationsBetweenDates(a,b);
        }else{
            return new ArrayList<>();
        }
    }
    public CompleteAndCancelled getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");

        int cantidadCompletadas = completed.size();
        int cantidadCanceladas = cancelled.size();

        return new CompleteAndCancelled( (long) cantidadCompletadas, (long) cantidadCanceladas);
    }

    public List<TotalAndClient>getTopClientsReport(){
        return reservationRepository.getTopClients();
    }
}
