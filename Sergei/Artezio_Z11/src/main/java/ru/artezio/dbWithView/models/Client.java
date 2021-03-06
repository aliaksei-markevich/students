package ru.artezio.dbWithView.models;

import ru.artezio.dbWithView.dto.AnotherId;

import javax.xml.bind.annotation.*;

/**
 * Класс реализующий харнение данных для клиентов (xls файл)
 */
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    private int idClient = -1;
    private String lastName;

    private String firstName;
    private int numberPhone;
    private AnotherId anotherId;

    public Client() {
    }

    public Client(int idClient, String lastName, String firstName, int numberPhone, AnotherId anotherId) {
        this(lastName, firstName, numberPhone, anotherId);
        this.idClient = idClient;

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


    @Override
    public String toString() {
        return this.lastName + " " + this.firstName + " " + this.numberPhone + " " + this.anotherId;
    }
}
