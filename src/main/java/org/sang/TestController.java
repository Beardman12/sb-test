package org.sang;

import org.sang.models.AuthorDto;
import org.sang.models.UserDto;
import org.sang.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

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

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request){
        String realPath=request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format=new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        File folder=new File(realPath+format);
        Boolean isSuccessMake;
        if(!folder.exists()){
            isSuccessMake= folder.mkdir();
            if(!isSuccessMake){

            }
        }

        String oldName=uploadFile.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.indexOf("."),oldName.length());
        try{

            uploadFile.transferTo(new File(folder,newName));
            String filePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/uploadFile"+format+newName;
            return  filePath;
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return  "failed";

    }
}
