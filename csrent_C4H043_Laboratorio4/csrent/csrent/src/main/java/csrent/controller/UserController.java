package csrent.controller;

import csrent.model.User;
import csrent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    private ArrayList<User> users;

    public UserController() {
        //users = new ArrayList<User>();

    }

    @GetMapping
    public ArrayList<User> getAll(){
        return service.getAll();
    }

    @PostMapping
    public User postUser(@RequestBody User user) {
        return service.add(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return service.search(id);
    }

    @PutMapping
    public User putUser(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id) {
        return service.delete(id);
    }

    @PatchMapping
    public User patchUser (@RequestBody User user) {
        return service.edit(user);
    }
}