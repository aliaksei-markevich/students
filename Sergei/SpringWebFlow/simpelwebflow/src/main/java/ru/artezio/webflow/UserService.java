package ru.artezio.webflow;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.webflow.execution.RequestContext;
import ru.artezio.webflow.exceptions.UserEmptyField;

import java.util.ArrayList;

@Component
public class UserService {

    private ArrayList<User> userArrayList = new ArrayList<>();

    public UserService() {
        UserFactory<User> userFactory = User::new;
        userArrayList.add(userFactory.create("user", "pass"));
    }

    public String checkUser(User user) {
        if (userArrayList.contains(user)) {
            return "success";
        }
        return "failed";
    }

    public String createUser(User user, RequestContext context) throws UserEmptyField {
        if (user.getName().equals("") || user.getPassword().equals("")) {
            throw new UserEmptyField(new MessageBuilder().code("empty").build().toString());
        }
        if (userArrayList.stream()
                .filter(user1 -> user1.getName().equals(user.getName())).findFirst().isPresent()) {
            return "exist";
        } else {
            userArrayList.add(user);
            context.getMessageContext().addMessage(new MessageBuilder().code("user_success_create").build());
            return "end";
        }
    }
}
