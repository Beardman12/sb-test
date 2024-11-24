package org.sang;

import org.sang.models.AuthorDto;
import org.sang.models.UserDto;
import org.sang.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private AuthorDto authorDto;  // 自动注入 AuthorDto


   private final IUserService userService;

    @Autowired
    public  TestController(IUserService userService){
        this.userService=userService;
    }

    @GetMapping("/test")
    public String hello() {
        return "hello spring boot!";
    }

    @GetMapping("/test2")
    public String hello2() {
        return "hello1  hi test 22!";
    }

    @GetMapping("/getusers")
    public UserDto getUserInfo(){
        List<UserDto> users= userService.GetAllUsers();
        if(users.isEmpty())
            return null;

        return users.get(0);
    }
    @GetMapping("/getauthor")
    public AuthorDto getAuthor(){

        return authorDto;
    }
}
