package com.example.HW1;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/path")
public class HW1_Controller {

    @RequestMapping("/{name}/{age}/{school}/{major}/{mbti}")
    public String path(@PathVariable String name, @PathVariable int age
            , @PathVariable String school, @PathVariable String major, @PathVariable String mbti) {
        return "안녕하세요. 저의 자기소개를 하겠습니다. 저의 이름은 " + name + " 입니다. 저는 " + age + "입니다. 학교는 " + school +
                "이고, 전공은 " + major + "입니다. 마지막으로 저의 mbti는 " + mbti + "입니다. 감사합니다.";
    }

    @PostMapping("")
    public String postUser(){
        return "자기소개 하기";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId){
        return "id : "+ userId;
    }

    @PatchMapping("/{userId}")
    public String patchUser(@PathVariable Long userId){
        return "바꿀 id : " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return "삭제할 id : " + userId;
    }


}