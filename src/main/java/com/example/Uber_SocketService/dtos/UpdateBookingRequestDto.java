package com.example.Uber_SocketService.dtos;

import com.example.Uber_Entity.models.BookingStatus;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBookingRequestDto {

    private BookingStatus status;
    private Optional<Long> driverId;

}