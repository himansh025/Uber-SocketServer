package com.example.Uber_SocketService.dtos;

import com.example.Uber_SocketService.models.ExactLocation;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideRequestDto {
    private  Long passengerId;
    private  ExactLocation startLocation;
    private  ExactLocation endLocation;
    private List<Long> driverIds;
}
