package org.polytech.al.project1920.useraccount.beans;

import org.polytech.al.project1920.useraccount.model.User;
import org.polytech.al.project1920.useraccount.model.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserBean {

    private final UserDB userDB;

    @Autowired
    public UserBean(UserDB userDB) {
        this.userDB = userDB;
    }

    public User getUserByUserId(String userId) {
        actualizeMoney(userId);
        return userDB.findUserByUserId(userId).orElse(userDB.findAll().get(0));
    }

    public User getUserById(String id) {
        actualizeMoneyAllAccounts();
        return userDB.findById(id).orElse(userDB.findAll().get(0));
    }

    public List<User> getUsers() {
        actualizeMoneyAllAccounts();
        return userDB.findAll();
    }

    private void actualizeMoneyAllAccounts() {
        List<User> users = userDB.findAll();
        for (User user : users) {
            actualizeMoney(user.getUserId());
        }
    }

    private void actualizeMoney(String userId) {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        String result = builder.build().getForObject("http://192.168.99.102:8080/getAmount?userId=" + userId, String.class);

        Optional<User> user = userDB.findUserByUserId(userId);
        if (result != null && user.isPresent()) {
            user.get().setMoney(Float.parseFloat(result));
            userDB.save(user.get());
        }
    }

    public String prettyDump() {
        actualizeMoneyAllAccounts();

        StringBuilder prettyDump = new StringBuilder();

        List<User> Users = userDB.findAll();

        prettyDump.append("\n------ USERS PRETTY DUMP ------").append("\n");
        prettyDump.append("Here is the list of all existing accounts : \n");
        for (User user : Users) {
            prettyDump.append("\n").append("UserId : ").append(user.getUserId()).append("\n");
            prettyDump.append("Password : ").append(user.getPassword()).append("\n");
            prettyDump.append("Age : ").append(user.getAge()).append("\n");
            prettyDump.append("Money on the related bank account : ").append(user.getMoney()).append("\n");
        }

        prettyDump.append("\n------ END OF USERS PRETTY DUMP ------\n");

        System.out.println(prettyDump);
        return prettyDump.toString();
    }
}
