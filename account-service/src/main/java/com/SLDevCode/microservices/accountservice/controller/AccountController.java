package com.SLDevCode.microservices.accountservice.controller;

import com.SLDevCode.microservices.accountservice.dto.UserRequest;
import com.SLDevCode.microservices.accountservice.dto.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("users")
public class AccountController {

    @PostMapping(consumes = "application/json" , produces = "application/json")
    public @ResponseBody UserResponse createUser(@RequestBody UserRequest userRequest){

        System.out.println("User Details : " + userRequest);

        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(UUID.randomUUID().toString());
        userResponse.setMessage("Successfuly Create the User");

        return userResponse;


    }
}
