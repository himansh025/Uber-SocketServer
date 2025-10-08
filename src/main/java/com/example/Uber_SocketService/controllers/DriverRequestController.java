package com.example.Uber_SocketService.controllers;

import com.example.Uber_Entity.models.BookingStatus;
import com.example.Uber_SocketService.Producers.KafakProducerService;
import com.example.Uber_SocketService.dtos.RideRequestDto;
import com.example.Uber_SocketService.dtos.RiderResposneDto;
import com.example.Uber_SocketService.dtos.UpdateBookingRequestDto;
import com.example.Uber_SocketService.dtos.UpdateBookingResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller("/api/socket")
public class DriverRequestController {
    private KafakProducerService kafakProducerService;
    private final SimpMessagingTemplate simpMessagingTemplate;
    private  final RestTemplate restTemplate;

    public DriverRequestController(KafakProducerService kafakProducerService, SimpMessagingTemplate simpMessagingTemplate, RestTemplate restTemplate) {
        this.kafakProducerService = kafakProducerService;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public Boolean help(){
        this.kafakProducerService.publishMessage("sample-topic" ,"hello-fuck you");
        return true;
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
    @MessageMapping("/riderResponse/{userId}")
    public synchronized void riderResponseHandler(@DestinationVariable String userId, RiderResposneDto riderResposneDto){
//        ride response dto contain bookingId and status
        UpdateBookingRequestDto requestDto= UpdateBookingRequestDto.builder()
                .driverId(Optional.of(Long.parseLong(userId)))
                .status(BookingStatus.valueOf("SCHEDULED"))
                .build();


       ResponseEntity< UpdateBookingResponseDto> result = this.restTemplate.postForEntity("http://localhost:8000/api/v1/booking/"+riderResposneDto.getBookingId(),requestDto, UpdateBookingResponseDto.class);
        System.out.println(riderResposneDto.getResposne());
    }


}
