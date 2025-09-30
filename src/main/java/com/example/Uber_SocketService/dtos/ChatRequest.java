package com.example.Uber_SocketService.dtos;

import lombok.*;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class ChatRequest {
        private String name;
        private String message;
    }
