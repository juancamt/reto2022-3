package proyectoReto3.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectoReto3.reto3.entities.Reservation;
import proyectoReto3.reto3.entities.dtos.CompleteAndCancelled;
import proyectoReto3.reto3.entities.dtos.TotalAndClient;
import proyectoReto3.reto3.service.ReservationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation>  getALl(){
        return  reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idReservation){
        return reservationService.getReservation(idReservation);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation c){
        return reservationService.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    //reto5

    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public List<Reservation>getReservationBetweenDatesReport(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2")String fecha2){
        return reservationService.getReservationBetweenDatesReport(fecha1,fecha2);
    }
    @GetMapping("/report-status")
    public CompleteAndCancelled getReservationStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<TotalAndClient>getTopClientsReport(){
        return reservationService.getTopClientsReport();
    }
}
