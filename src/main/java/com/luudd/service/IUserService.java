package com.luudd.service;

import java.util.List;

import com.luudd.entity.User;
import com.luudd.model.dto.UserDTO;
import com.luudd.model.request.UserRequest;

public interface IUserService {
	
	public UserDTO createUser(UserRequest userRequest);

    public User updateUser(UserRequest userRequest, int id);

    public String deleteUser(int id);

    public UserDTO getUserById(int id);

    public UserDTO searchByName(String keyword);
    
    public List<UserDTO> getAllUsers();
}
