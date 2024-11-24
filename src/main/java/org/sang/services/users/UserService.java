package org.sang.services.users;

import org.apache.catalina.User;
import org.sang.models.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Override
    public List<UserDto> GetAllUsers() {
        List<UserDto> users=new ArrayList<>();
        UserDto user1= getUserDto("zzd","男",16);

        users.add(user1);
        return users;
    }

    private  UserDto getUserDto(String name,String gender,Integer age){
        UserDto user1= new UserDto();
        user1.setAge(age);
        user1.setGender(gender);
        user1.setName(name);
        return  user1;
    }
}
