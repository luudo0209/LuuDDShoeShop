package com.luudd.model.mapper;

import com.luudd.entity.User;
import com.luudd.model.dto.UserDTO;

public class UserMapper {
	
	public static UserDTO toUserDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setUserName(user.getUserName());
        userDto.setUserId(user.getUserId());
        userDto.setUserRole(user.getUserRole());
        userDto.setUserPassword(user.getUserPassword());
        return userDto;
    }
}
