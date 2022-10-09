package proyectoReto3.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "clienId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    @ManyToOne
    @JoinColumn(name = "partyroomId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Partyroom partyroom;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Partyroom getPartyroom() {
        return partyroom;
    }

    public void setPartyroom(Partyroom partyroom) {
        this.partyroom = partyroom;
    }
}
