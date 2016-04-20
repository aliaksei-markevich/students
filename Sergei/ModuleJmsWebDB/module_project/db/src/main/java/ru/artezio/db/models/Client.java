package ru.artezio.db.models;

import ru.artezio.db.dto.AnotherId;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

/**
 * Класс реализующий харнение данных для клиентов (xls файл)
 */
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", unique = true, nullable = false)
    private int idClient;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "prone_number")
    private int numberPhone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstId", column = @Column(name = "first_id")),
            @AttributeOverride(name = "mainId", column = @Column(name = "main_id")),
            @AttributeOverride(name = "secondId", column = @Column(name = "second_id"))
    })
    private AnotherId anotherId;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },  targetEntity = Position.class)
    @JoinTable(name = "clients_positions", joinColumns = {
            @JoinColumn(name = "id_client", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_position", insertable = false,nullable = false, updatable = false)})
    private Set<Position> positions = new HashSet<Position>();

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public Client() {
    }

    public Client(int idClient, String lastName, String firstName, int numberPhone, AnotherId anotherId) {
        this(lastName, firstName, numberPhone, anotherId);
        this.idClient = idClient;

    }

    public void addPosition(Position position) {
        this.positions.add(position);
    }

    public Client(String lastName, String firstName, int numberPhone, AnotherId anotherId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.numberPhone = numberPhone;
        this.anotherId = anotherId;
    }


    public int getIdClient() {
        return idClient;
    }


    public String getLastName() {
        return lastName;
    }


    public String getFirstName() {
        return firstName;
    }


    public int getNumberPhone() {
        return numberPhone;
    }


    public AnotherId getAnotherId() {
        return anotherId;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setAnotherId(AnotherId anotherId) {
        this.anotherId = anotherId;
    }

    public String showPositions() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        for (Position position : positions) {
            sb.append(delim).append(position.getPositionName());
            delim = ",";
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.lastName + " " + this.firstName + " " + this.numberPhone + " " + this.anotherId;
    }

    public Client(String lastName, String firstName, int numberPhone, AnotherId anotherId, Set<Position> positions) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.numberPhone = numberPhone;
        this.anotherId = anotherId;
        this.positions = positions;
    }
}
