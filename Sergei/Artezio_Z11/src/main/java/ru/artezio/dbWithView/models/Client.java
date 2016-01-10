package ru.artezio.dbWithView.models;

/**
 * Класс реализующий харнение данных для клиентов (xls файл)
 */
public class Client {

    private int idClient;
    private String lastName;
    private String firstName;
    private int numberPhone;
    private int anotherId;

    public Client(int idClient, String lastName, String firstName, int numberPhone, int anotherId) {
        this.idClient = idClient;
        this.lastName = lastName;
        this.firstName = firstName;
        this.numberPhone = numberPhone;
        this.anotherId = anotherId;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAnotherId() {
        return anotherId;
    }

    public void setAnotherId(int anotherId) {
        this.anotherId = anotherId;
    }
}
