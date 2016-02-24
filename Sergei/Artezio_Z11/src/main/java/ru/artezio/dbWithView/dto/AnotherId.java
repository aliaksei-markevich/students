package ru.artezio.dbWithView.dto;

public class AnotherId {
    int firstId;
    int secondId;
    int mainId;

    public AnotherId() {
    }

    public AnotherId(int firstId, int secondId, int mainId) {
        this.firstId = firstId;
        this.secondId = secondId;
        this.mainId = mainId;
    }

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public int getMainId() {
        return mainId;
    }

    public void setMainId(int mainId) {
        this.mainId = mainId;
    }

    @Override
    public String toString() {
        return "AnotherId{" +
                "firstId=" + firstId +
                ", secondId=" + secondId +
                ", mainId=" + mainId +
                '}';
    }
}
