package com.unihack.unihackbe.controller;

import com.unihack.unihackbe.entity.dto.AvatarDto;
import com.unihack.unihackbe.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

    private final AvatarService avatarService;

    @Autowired
    public Controller(AvatarService avatarService) {
        this.avatarService = avatarService;
    }


    @GetMapping("/getAvatars")
    public List<String> getListOfAvatars() {
        System.out.println(avatarService.getAvatars());
        return avatarService.getAvatars();
    }

    @RequestMapping
    public String test() {
        return "Project is up and running";
    }




}
