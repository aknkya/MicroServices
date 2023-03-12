package com.example.demo.controller;


import com.example.demo.repository.MenuRepo;
import com.example.demo.entity.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MenuController {
    @Autowired
    private MenuRepo menuRepo;

    @PostMapping("/send")
    public MessageModel save(@RequestBody MessageModel messageModelDetails) {
        String host = "localhost";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);
        jedis.publish("MENU-ITEM", messageModelDetails.getMessage());
        jedis.close();
        return menuRepo.save(messageModelDetails);
    }



    @GetMapping("/getAll")
    public List<MessageModel> getMenus() {
        return menuRepo.findAll();
    }

    @GetMapping("/getById/{id}")
    public MessageModel findMenuItemById(@PathVariable int id) {
        return menuRepo.findItemById(id);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteMenuById(@PathVariable int id)   {
        return menuRepo.deleteMenu(id);
    }
}
