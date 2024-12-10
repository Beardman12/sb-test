package org.sang;

import org.sang.models.AuthorDto;
import org.sang.models.Book;
import org.sang.models.UserDto;
import org.sang.services.books.IBookService;
import org.sang.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
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
   private final IBookService bookService;

    @Autowired
    public  TestController(IUserService userService,
                           IBookService bookService){
        this.userService=userService;
        this.bookService=bookService;
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
    public String uploadFile(MultipartFile uploadFile) {
        if (uploadFile.isEmpty()) {
            return "上传失败，文件为空";
        }

        try {
            String UPLOAD_DIR="uploads";
            // 项目目录下的文件夹
            String filePath = new File(System.getProperty("user.dir"), "uploads").getAbsolutePath();
            File uploadFolder = new File(filePath);

            // 确保文件夹存在
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
            }
            // 保存文件到指定路径
            uploadFile.transferTo(new File(filePath,uploadFile.getOriginalFilename()));
            return "文件上传成功，路径：" + filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败，错误信息：" + e.getMessage();
        }
    }

}
