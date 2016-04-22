package ru.artezio.db.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_position", unique = true, nullable = false)
    private int positionID;

    @Column(name = "position", unique = true, nullable = false)
    private String positionName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "positions")
    private Set<Client> clients = new HashSet<Client>();

    public Position() {
    }

    public Position(int positionID) {
        this.positionID = positionID;
    }

    public Position(String positionName) {
        this.positionName = positionName;
    }

    public Position(int positionID, String positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void setEmployees(Set<Client> clients) {
        this.clients = clients;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
