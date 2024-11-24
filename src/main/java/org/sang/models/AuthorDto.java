package org.sang.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AuthorDto {

      public AuthorDto(@Value("${author.birthday}") String datetimeStr) {
            this.birth = LocalDateTime.parse(datetimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }


    @Value("${author.name}")
     private  String name;
    @Value("${author.gender}")
    private  String gender;
    @Value("${author.age}")
    private  Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birth;
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDateTime  getBirth() {
        return birth;
    }

}
