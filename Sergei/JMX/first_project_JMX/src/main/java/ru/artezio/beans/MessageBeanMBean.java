package ru.artezio.beans;

/**
 * Created by Ivko Serhei on 10.06.2016.
 */
public interface MessageBeanMBean {
    String getMessage();
    void setMessage(String message);
    String takeMessage();
    void inputMessage(String message);
}
