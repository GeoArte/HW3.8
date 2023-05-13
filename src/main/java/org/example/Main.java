package org.example;

import Users.User;
import Users.UserDAO;
import Users.UserDAOImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();

        // Получение списка пользователей
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            System.out.println(user.getName());
        }

        // Получение конкретного пользователя по id
        User user = userDAO.getUserById(1L);
        if (user != null) {
            System.out.println(user.getName());
        }

        // Получение списка пользователей по роли
        List<User> usersByRole = userDAO.getUsersByRole("Разработчик");
        for (User user1 : usersByRole) {
            System.out.println(user1.getName());
        }

        // Удаление пользователя, если пользователь найден
        if (user != null) {
            userDAO.deleteUser(user);
            user = null;
        }

        // Создание нового пользователя
        User newUser = new User();
        // Заполнение данных нового пользователя
        newUser.setName("Новый пользователь");
        newUser.setLogin("newuser");
        newUser.setPassword("password");
        // ...
        userDAO.addUser(newUser);

        // Редактирование существующего пользователя, если пользователь найден
        if (user != null) {
            user.setName("Новое имя");
            // ...
            userDAO.updateUser(user);
        }
    }
}
