package com.example.demo.repository;


import com.example.demo.entity.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepo {

    public static final String HASH_KEY_NAME = "MENU-ITEM";
    @Autowired
    private RedisTemplate redisTemplate;


    public MessageModel save(MessageModel messageModel){
        redisTemplate.opsForHash().put(HASH_KEY_NAME, messageModel.getId(), messageModel);
        return messageModel;
    }

    public List<MessageModel> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY_NAME);
    }

    public MessageModel findItemById(int id){
        return (MessageModel) redisTemplate.opsForHash().get(HASH_KEY_NAME,id);
    }


    public String deleteMenu(int id){

        redisTemplate.opsForHash().delete(HASH_KEY_NAME,id);
        return "Menu deleted successfully !!";
    }
}
