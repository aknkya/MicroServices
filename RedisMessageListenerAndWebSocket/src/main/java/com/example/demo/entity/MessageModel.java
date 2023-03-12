package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Menu")
public class MessageModel implements Serializable {
    @Id
    private int id;

    private String message;

    public int getId() {
        return id;
    }

    public MessageModel setId(int id) {
        this.id = id;
        return this;
    }

    public MessageModel(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public MessageModel setMessage(String message) {
        this.message = message;
        return this;
    }
}
