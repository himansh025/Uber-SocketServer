package com.example.Uber_SocketService.dtos;

import com.example.Uber_Entity.models.BookingStatus;
import com.example.Uber_Entity.models.Driver;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookingResponseDto {

    private Long bookingId;
    private BookingStatus status;
    private Optional<Driver> driver;

}