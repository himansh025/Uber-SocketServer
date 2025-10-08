package com.example.Uber_SocketService.controllers;

import com.example.Uber_SocketService.dtos.TestRequest;
import com.example.Uber_SocketService.dtos.TestResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;

@Controller
public class TestController {


    @MessageMapping("/ping")
    @SendTo("/topic/ping")
    public TestResponse pingCheck(TestRequest message){
        System.out.println(message);
        return   TestResponse.builder().data("connect").build();
    }
}
