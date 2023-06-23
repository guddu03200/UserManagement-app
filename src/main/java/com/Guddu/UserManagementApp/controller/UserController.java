package com.Guddu.UserManagementApp.controller;

import com.Guddu.UserManagementApp.model.User;
import com.Guddu.UserManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    @Autowired
    UserService userService;


    //read
    @PostMapping("user")    //addUser
    public String addUser(@RequestBody User u)
    {
        return userService.inputUser(u);
    }
    @PostMapping("users")
    public String addUsers(@RequestBody List<User>u)
    {
        return userService.inputUsers(u);
    }



    @GetMapping("users")  //getAllUser
    public List<User> getAllUsers()
    {
        return userService.getAllUser();
    }

    @GetMapping("user/{iD}") //getUser/{userid}

    public User getUserById(@PathVariable Integer iD)
    {
        return userService.getUser(iD);
    }


    //	updateUserInfo Phone and Address
    @PutMapping("user/{iD}/number/{num}")
    public String updateUserNumById(@PathVariable Integer iD,@PathVariable String num)
    {
        return userService.updateUserNumber(iD,num);
    }

    @PutMapping("user/{iD}/address/{address}")
    public String updateUserAddressById(@PathVariable Integer iD,@PathVariable String address)
    {
        return userService.updateUserAddress(iD,address);
    }



    //deleteUser
    @DeleteMapping("user/{iD}")
    public String deleteUserById(@PathVariable Integer iD)
    {
        return userService.deleteUser(iD);
    }
}
