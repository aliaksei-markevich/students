package ru.artezio.dbWithView.dto;

public class AnotherId {
    int first_id;
    int second_id;
    int main_id;

    public AnotherId() {
    }

    public AnotherId(int first_id, int second_id, int main_id) {
        this.first_id = first_id;
        this.second_id = second_id;
        this.main_id = main_id;
    }

    public int getFirst_id() {
        return first_id;
    }

    public void setFirst_id(int first_id) {
        this.first_id = first_id;
    }

    public int getSecond_id() {
        return second_id;
    }

    public void setSecond_id(int second_id) {
        this.second_id = second_id;
    }

    public int getMain_id() {
        return main_id;
    }

    public void setMain_id(int main_id) {
        this.main_id = main_id;
    }

    @Override
    public String toString() {
        return "AnotherId{" +
                "first_id=" + first_id +
                ", second_id=" + second_id +
                ", main_id=" + main_id +
                '}';
    }
}
