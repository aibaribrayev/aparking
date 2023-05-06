package com.example.kafkaconsumerservice.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Service
public class WebSocketConfiguration implements WebSocketConfigurer {
    @Autowired
    private ParkingSpotWebSocketHandler parkingSpotWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(parkingSpotWebSocketHandler, "/parking-spot-updates")
                .setAllowedOrigins("*");
    }
}
