package com.adamborowski.forumapp.repository;

import com.adamborowski.forumapp.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UsersRepository {

    private List<User> listOfUsers = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong(0);
    private List<User> bannedUsers = new ArrayList<>();

    public User createUser(User user) {
        user.setId(idCounter.getAndIncrement());
        listOfUsers.add(user);
        return user;
    }

    public List<User> getAllUsers() {

        return listOfUsers;
    }

    public User findUserByLogin(String login) {
        return listOfUsers.stream().filter(e -> e.getLogin().equals(login)).findAny().orElseGet(null);

    }

    public void banUserByLogin(String login) {
        User user = listOfUsers.stream().filter(e -> e.getLogin().equals(login)).findAny().orElseGet(null);
        listOfUsers.remove(user);
        bannedUsers.add(user);
    }

    public List<User> getAllBannedUsers() {
        return bannedUsers;
    }
}
