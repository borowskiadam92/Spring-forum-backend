package com.adamborowski.forumapp.controller;

import com.adamborowski.forumapp.domain.User;
import com.adamborowski.forumapp.dto.CreateUser;
import com.adamborowski.forumapp.repository.UsersRepository;
import com.adamborowski.forumapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    private UserService usersService;
    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Autowired
    public UsersController(UserService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUser user) {

        User u = usersService.createUser(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> listOfUsers = usersService.getAllUsers();
        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
    }

    @GetMapping("/banned")
    public ResponseEntity<List<User>> getAllBannedUsers() {
        List<User> listOfUsers = usersService.getAllBannedUsers();
        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
    }

    @GetMapping("/{userLogin}")
    public ResponseEntity<User> findUserByLogin(@PathVariable String userLogin) {
        User user = usersService.findUserByLogin(userLogin);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @DeleteMapping("/banUser/{userLogin}")
    public ResponseEntity<Void> banUserByLogin(@PathVariable String userLogin) {
        usersService.banUserByLogin(userLogin);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

}
