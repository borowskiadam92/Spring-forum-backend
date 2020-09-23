package com.adamborowski.forumapp.service;

import com.adamborowski.forumapp.domain.User;
import com.adamborowski.forumapp.dto.CreateUser;
import com.adamborowski.forumapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User createUser(CreateUser createUser) {

        User user = User.builder()
                .name(createUser.getName())
                .email(createUser.getEmail())
                .surname(createUser.getSurname())
                .login(createUser.getLogin())
                .password(createUser.getPassword())
                .confirmPassword(createUser.getConfirmPassword())
                .time(LocalDateTime.now())
                .build();

        usersRepository.createUser(user);
        return user;
    }

    public boolean isLoginExist(String login) {
        if (login.equals(usersRepository.findUserByLogin(login))) {
            return true;
        } else if (login.equals(null)) {
            return false;
        }
        return false;
    }


    public List<User> getAllUsers() {
        return usersRepository.getAllUsers();
    }

    public User findUserByLogin(String login) {
        return usersRepository.findUserByLogin(login);
    }

    public void banUserByLogin(String login) {
        usersRepository.banUserByLogin(login);
    }

    public List<User> getAllBannedUsers() {
        return usersRepository.getAllBannedUsers();
    }

}
