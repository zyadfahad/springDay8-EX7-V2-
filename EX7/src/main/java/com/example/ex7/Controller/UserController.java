package com.example.ex7.Controller;

import com.example.ex7.Exceptionn.ApiException;
import com.example.ex7.Model.UserModel;
import com.example.ex7.Servise.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<UserModel> users = userService.getUser();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addUser(UserModel user , Errors errors){
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("added");
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody@Valid UserModel userModel, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(userService.updateUser(id,userModel))return ResponseEntity.status(200).body("updated");
       return ResponseEntity.status(400).body("wrong ID");
    }
    @DeleteMapping("/del/{index}")
    public ResponseEntity delateUser(@PathVariable Integer id,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(userService.delateUser(id))return ResponseEntity.status(200).body("updated");
        return ResponseEntity.status(400).body("wrong ID");
    }
    @GetMapping("/byemail/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        UserModel userModel = userService.getUserByEmail(email);
        return ResponseEntity.status(200).body(userModel);
    }
    @GetMapping("/byrole/{role}")
    public List<UserModel> getUserByRole(@PathVariable String role){
        List<UserModel> userModel = userService.userRepository.findAllByRole(role);
        if(userModel==null)throw new ApiException("wrong role");

        return userModel;
    }
    @GetMapping("/getby/{age}")
    public ResponseEntity getUsersByAge(@PathVariable Integer age)
    {
        return ResponseEntity.status(201).body(userService.getUserByAge(age));
    }


}
