package cz.upce.fei.nnpiacv.service;

import cz.upce.fei.nnpiacv.domain.User;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final Map<Long, User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        User user1 = new User(0L, "email1@email.com", "password");
        User user2 = new User(1L, "email2@email.com", "password2");
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
    }

    public Collection<User> findUsers() {
        return users.values();
    }

    public User findUserById(Long id) {
        log.debug("User found: {}", users.get(id));
        return users.get(id);
    }
}
