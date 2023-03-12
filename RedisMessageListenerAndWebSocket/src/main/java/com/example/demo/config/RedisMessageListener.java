package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RedisMessageListener implements MessageListener {

    @Autowired
    WebSocketHandler webSocketHandler;



    @Override
    public void onMessage(Message message, byte[] pattern) {
        WebSocketClientConfig webSocketClientConfig=new WebSocketClientConfig("ws://localhost:8090/chat");
        String channel = new String(message.getChannel());
        String body = new String(message.getBody());
        System.out.println("Received message: " + body + " from channel: " + channel);
        try {
            webSocketClientConfig.sendMessage(body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
