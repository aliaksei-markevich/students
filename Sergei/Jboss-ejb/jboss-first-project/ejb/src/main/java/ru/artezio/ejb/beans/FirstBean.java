package ru.artezio.ejb.beans;

import javax.ejb.Stateless;

@Stateless
public class FirstBean implements FirstBeanRemote {

    @Override
    public String getGreetingMessage(String name) {
        return String.format("Hello %s !!", name);
    }
}
