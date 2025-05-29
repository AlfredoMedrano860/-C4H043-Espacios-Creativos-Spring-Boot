package csrent.controller;

import csrent.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class UserController {

    private ArrayList<User> users;

    public UserController() {
        //users = new ArrayList<User>();

    }

    @GetMapping("/user")
    public ArrayList<User> getAll() {
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        for (int element = 0; element < users.size(); element++) {
            if (users.get(element).getId() == id) {
                return users.get(element);
            }
        }
        return new User();
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @PutMapping("/user")
    public User putUser(@RequestBody User user) {
        for (int element = 0; element < users.size(); element++) {
            if (users.get(element).getId() == user.getId()) {
                return users.set(element, user);
            }
        }
        return new User();
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable int id) {
        for (int element = 0; element < users.size(); element++) {
            if (users.get(element).getId() == id) {
                return users.remove(element);
            }
        }
        return new User();
    }

    @PatchMapping("/user")
    public User patchUser(@RequestBody User user) {
        for (int element = 0; element < users.size(); element++) {
            if (users.get(element).getId() == user.getId()) {
                if (user.getName() != null) {
                    users.get(element).setName(user.getName());
                }
                if (user.getType() != null) {
                    users.get(element).setType(user.getType());
                }
                return users.get(element);
            }
        }
        return new User();
    }
}