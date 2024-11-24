package org.sang.services.users;

import org.sang.models.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> GetAllUsers();
}
