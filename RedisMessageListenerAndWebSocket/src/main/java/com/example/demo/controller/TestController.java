package com.example.demo.controller;


import com.example.demo.config.WebSocketClientConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.DeploymentException;
import java.io.IOException;

@RestController
public class TestController {

    @GetMapping("towebesocket")
    public void sendToWebScoket() throws DeploymentException, IOException {
        WebSocketClientConfig webSocketClientConfig=new WebSocketClientConfig("ws://localhost:8090/chat");
        webSocketClientConfig.sendMessage("THİS İS CLİENT SMS");

    }
}
