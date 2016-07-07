package ru.artezio.webflow;

/**
 * Created by Администратор on 07.07.2016.
 */
@FunctionalInterface
public interface UserFactory<P extends User> {
    P create(String login, String password);
}
