package ru.artezio.ejb.beans;

import javax.ejb.Remote;

@Remote
public interface FirstBeanRemote {
    String getGreetingMessage(String name);
}
