package proyectoReto3.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import proyectoReto3.reto3.entities.Message;
import proyectoReto3.reto3.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/Message")

public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message>  getALl(){
        return  messageService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message c){
        return messageService.save(c);
    }
}
