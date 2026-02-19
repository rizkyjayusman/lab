package com.rizkyjayusman.validation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
    @PostMapping
    public void create(@Validated(CreateGroup.class) @RequestBody MemberRequest request) {
        System.out.println("name: " + request.getName());
        System.out.println("email: " + request.getEmail());
    }
}
