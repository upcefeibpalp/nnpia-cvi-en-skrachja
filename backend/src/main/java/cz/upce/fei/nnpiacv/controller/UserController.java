package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.User;
import cz.upce.fei.nnpiacv.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/user") // Změněná základní adresa z /users na /user
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Původní endpoint pro získání všech uživatelů (přesunut z /users na /user)
    @GetMapping
    public Collection<User> findAllUsers() {
        return userService.findUsers();
    }

    // Endpoint s Query parametrem: /user?id=1
    @GetMapping(params = "id")
    public User findUserByQueryParam(@RequestParam Long id) {
        return Optional.ofNullable(userService.findUserById(id))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Endpoint s Path parametrem: /user/1
    @GetMapping("/{id}")
    public User findUserByPathParam(@PathVariable Long id) {
        return Optional.ofNullable(userService.findUserById(id))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
