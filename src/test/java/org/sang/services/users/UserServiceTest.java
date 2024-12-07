package org.sang.services.users;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.models.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    IUserService _userService;

    @Test
    public void testGetAllUsers(){
        List<UserDto> users= _userService.GetAllUsers();
        Assert.assertTrue(users!=null&&users.size()>0);
    }
}
