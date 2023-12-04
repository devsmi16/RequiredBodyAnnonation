package com.devsmi.RequiredBodyAnnotation.controller;

import com.devsmi.RequiredBodyAnnotation.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RequestBodyController {

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){ // bu şekilde yazdığımızda kullanıcı JSON modeli gönderecek
        System.out.println("User Saved");
        user.setPassword(""); // örneğin güvenlik açısından zafiyet oluşturmaması için boş bi şekilde sent edebiliriz postman'e
        return user;
    }

    @PostMapping("/users-list")
    public List<User> saveAllUser(@RequestBody List<User> users){ // liste şeklinde birden fazla user'lar postman'de tetiklenebilir hale gelebilir.
        System.out.println("All users Saved");
        users.forEach(user -> user.setPassword(""));
        return users;
    }
}
