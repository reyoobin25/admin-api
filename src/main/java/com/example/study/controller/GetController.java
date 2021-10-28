package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
    public String getRequest() {

        return "Hi getMethod!";
    }

    @GetMapping("/getParameter") // localhost:8080/api/getParameter?id=123&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        String password = "ppp";

        System.out.println("id : " + id);
        System.out.println("password : " + pwd);

        return id+pwd;
    }

    // http://localhost:8080/api/getMultiParameter?account=123&email=yyyymmdd&page=1
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println("account : " + searchParam.getAccount());
        System.out.println("email : " + searchParam.getEmail());
        System.out.println("page : " + searchParam.getPage());

        // {"account":"", "email":"", "page":0}
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader() {

        // 예상 = {"resultCode" : "OK", "description" : "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
