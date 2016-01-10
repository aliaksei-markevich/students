package ru.artezio.dbWithView.models;

/**
 * Класс реализующий хранение данных для ветвей(csv файл)
 */
public class TreeBranch {

    private int id;
    private String text;
    private int parentId;

    public TreeBranch(int id, String text, int parentId) {
        this.id = id;
        this.text = text;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
