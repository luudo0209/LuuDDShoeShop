package com.luudd.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luudd.entity.User;
import com.luudd.model.dto.UserDTO;
import com.luudd.model.mapper.UserMapper;
import com.luudd.model.request.UserRequest;
import com.luudd.repository.IUserRepository;
import com.luudd.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
    private IUserRepository userRepository;
	
	@Override
	public UserDTO createUser(UserRequest userRequest) {
		User user = new User();
		UserDTO userdto = new UserDTO();
		Date date  = new Date();
		user.setUserName(userRequest.getUserName());
		user.setPhoneNumber(userRequest.getPhone());
		user.setUserPassword("1");
		user.setCreatedAt(date);
		user.setCreatedBy("Ludd");
		user.setUpdatedAt(date);
		user.setUpdatedBy("Luudd");
		userRepository.save(user);
		
		userdto.setUserId(user.getUserId());
		userdto.setUserName(user.getUserName());
		userdto.setUserRole(user.getUserRole());
		return userdto;
	}

	@Override
	public User updateUser(UserRequest userRequest, int id) {
		List<User> userList = userRepository.findAll();
		for (User user : userList) {
			if(id == user.getUserId()) {
				user.setUserName(user.getUserName());
				user.setUserRole(user.getUserRole());
				return user;
			}
		}
		return null;
	}

	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "Sucess";
	}

	@Override
	public UserDTO getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
	     return UserMapper.toUserDto(user.get());
	}

	@Override
	public UserDTO searchByName(String keyword) {
		List<UserDTO> userDTOList = getAllUsers();
		for (UserDTO userDTO : userDTOList) {
			if(keyword.equals(userDTO.getUserName())) {
				return userDTO;
			}
		}
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserDTO> userDTOList = new ArrayList<>();
		for (User user : userList) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserName(user.getUserName());
			userDTO.setUserId(user.getUserId());
			userDTO.setUserRole(user.getUserRole());
			userDTOList.add(userDTO);
		}
		return userDTOList;
	}

}
