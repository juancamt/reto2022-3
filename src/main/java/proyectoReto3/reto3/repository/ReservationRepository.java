package proyectoReto3.reto3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import proyectoReto3.reto3.entities.Client;
import proyectoReto3.reto3.entities.Reservation;
import proyectoReto3.reto3.entities.dtos.TotalAndClient;
import proyectoReto3.reto3.repository.CrudRepository.ReservationCrudRepository;

import java.util.*;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation c) {
        return reservationCrudRepository.save(c);
    }

    public void delete(Reservation c) {
        reservationCrudRepository.delete(c);
    }

    public List<Reservation> getReservationsBetweenDates(Date fechaA, Date fechaB) {
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }

    public List<Reservation> getReservationsByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<TotalAndClient> getTopClients() {
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCrudRepository.getTotatlReservationsByClient();
        for (int i=0; i<reporte.size(); i++) {
            respuesta.add(new TotalAndClient( (Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

}
