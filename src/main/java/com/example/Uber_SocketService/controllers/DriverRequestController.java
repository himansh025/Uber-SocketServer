package com.example.Uber_SocketService.controllers;

import com.example.Uber_SocketService.dtos.RideRequestDto;
import com.example.Uber_SocketService.dtos.RiderResposneDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/api/socket")
public class DriverRequestController {

    private final SimpMessagingTemplate simpMessagingTemplate;


    public DriverRequestController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


//    booking service  this api with ride details to get the driver
    @PostMapping("/newride")
    public ResponseEntity<Boolean> raiseRideRequest(RideRequestDto rideRequestDto) {
        sendDriversNewRideRequest(rideRequestDto);
        return  new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    public void sendDriversNewRideRequest(RideRequestDto rideRequestDto) {
        System.out.println(rideRequestDto);
//        drivers listen the rides at this socket
        simpMessagingTemplate.convertAndSend("/topic/rideRequest", rideRequestDto);
    }

//    rider response about the ride
    @MessageMapping("/riderResponse")
    public  void riderResponseHandler(RiderResposneDto riderResposneDto){
        System.out.println(riderResposneDto.getResposne());
    }


}
