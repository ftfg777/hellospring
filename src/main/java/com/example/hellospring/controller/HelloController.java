package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){

        model.addAttribute("data", "hello!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")                    /* required = 기본 true / false 하면 값을 안 넘겨도 가능 */
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody /* 뷰를 거치지 않고 직접 문자로 반환함 소스 검사시 html 태그가 없이 문자만 보임  */
    public String helloSpring(@RequestParam("name")String name){
        return "hello " + name; //"hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody /* 객체를 반환하면 json 방식으로 출력 key:value */
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    /* model */
    static class Hello {
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }

    }
}
