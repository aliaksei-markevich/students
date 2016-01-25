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
        this(lastName, firstName, numberPhone, anotherId);
        this.idClient = idClient;

    }

    public Client(String lastName, String firstName, int numberPhone, int anotherId) {
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


    public int getAnotherId() {
        return anotherId;
    }

}
