package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // POST 발생
    // 1) HTML <Form>
    // 2) ajax 검색
    // http 통신시 body -> data
    // request form : json, xml, multipart-form / text-plain

    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put() {

    }

    @PatchMapping("patchMethod")
    public void patch() {

    }
}
