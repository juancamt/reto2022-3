package proyectoReto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoReto3.reto3.entities.Message;
import proyectoReto3.reto3.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message>getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message c){
        if(c.getIdMessage()==null){
            return messageRepository.save(c);
        }else {
            Optional<Message> e = messageRepository.getMessage(c.getIdMessage());
            if(e.isPresent()){
                return c;
            }else{
                return messageRepository.save(c);
            }
        }
    }
    public Message update(Message message){
        if (message.getIdMessage()!=null){
            Optional<Message> a = messageRepository.getMessage(message.getIdMessage());
            if(a.isPresent()){
                if (message.getMessageText()!=null){
                    a.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(a.get());
                return a.get();
            }else {
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean deleteMessage(int id){
        boolean d = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return  true;
        }).orElse(false);
        return d;
    }
}
