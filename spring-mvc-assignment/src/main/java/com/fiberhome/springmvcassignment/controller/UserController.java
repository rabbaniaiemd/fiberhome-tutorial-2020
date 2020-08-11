package com.fiberhome.springmvcassignment.controller;

import com.fiberhome.springmvcassignment.Service.UserService;
import com.fiberhome.springmvcassignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser() {
        try {
            List<User> employees = userService.findAllUsers();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * getAllEmployee
     * @param id
     * @return
     */
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getAllEmployee(@PathVariable("id") long id) {
        try {
            Optional<User> user = Optional.ofNullable(userService.findById(id));
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * saveEmployee
     * @param user user
     * @return ResponseEntity<Void>
     */
    @PostMapping("/insertUser")
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    /**
     *updateUser
     * @param id long
     * @param user user
     * @return ResponseEntity<User>
     */
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User currentUser = userService.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setName(user.getName());
        currentUser.setAge(user.getAge());
        currentUser.setSalary(user.getSalary());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    /**
     * deleteUser
     * @param id long
     * @return ResponseEntity<User>
     */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}



