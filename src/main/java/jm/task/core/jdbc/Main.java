package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();

        userServiceImpl.saveUser("Николай", "Гоголь", (byte) 22);
        userServiceImpl.saveUser("Лев", "Толстой", (byte) 45);
        userServiceImpl.saveUser("Максим", "Горький", (byte) 18);
        userServiceImpl.saveUser("Антон", "Чехов", (byte) 30);

        List<User> userList = userServiceImpl.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }

        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();
    }
}
