package com.luudd.controller;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.luudd.entity.User;
import com.luudd.model.dto.UserDTO;
import com.luudd.model.request.UserRequest;
import com.luudd.service.serviceImpl.UserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
    private UserService userService;
	// Get user by Id
    @ApiOperation(value="Get user by Id", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/api/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    // Get all users
    @ApiOperation(value="Get user by Id", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/api/user")
    public ResponseEntity<?> getAllUsers(){
    	//return (ResponseEntity<?>) userService.getAllUsers();
    	return ResponseEntity.ok(userService.getAllUsers());
    }
    // Create an user
    @ApiOperation(value="Create a user", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("/api/user")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRequest userRequest) {
        UserDTO user = userService.createUser(userRequest);
        return ResponseEntity.ok(user);
    }
    // Find user by Name or Email
    @ApiOperation(value="Find user by Name or Email", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("/api/userByNameOrEmail")
    public ResponseEntity<?> getUser(@RequestBody String searchKey){
    	//return (ResponseEntity<?>) userService.getAllUsers();
    	return ResponseEntity.ok(userService.searchByName(searchKey));
    }
    // Update user
    @ApiOperation(value="Update user", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PutMapping("/api/user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserRequest userRequest, @PathVariable int id) {
        User user = userService.updateUser(userRequest, id);
        return ResponseEntity.ok(user);
    }
    // Delete user
    @ApiOperation(value="Delete user", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
