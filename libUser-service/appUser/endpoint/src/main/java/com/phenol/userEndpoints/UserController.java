package com.phenol.userEndpoints;

import com.phenol.libuserservice.LibUserEntity;
import com.phenol.libuserservice.dto.LibUserDTO;
import com.phenol.userService.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/test")
    public String test() {
        return "Hello User..!";
    }

    // User CRUD
    @GetMapping("/get")
    public List<LibUserDTO> getAllUsers() {
        return userServices.getAllUsers();
    }

    @PostMapping("/post")
    public LibUserDTO createUser(@RequestBody LibUserEntity user) {
        return userServices.createUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userServices.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
