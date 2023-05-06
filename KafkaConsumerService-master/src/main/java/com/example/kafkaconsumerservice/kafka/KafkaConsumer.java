package com.example.kafkaconsumerservice.kafka;


import com.example.kafkaconsumerservice.model.ParkingSensor;
import com.example.kafkaconsumerservice.model.ParkingSpot;
import com.example.kafkaconsumerservice.service.ParkingService;
import com.example.kafkaconsumerservice.socket.ParkingSpotWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumer {
    @Autowired
    private ParkingService parkingService;
    //@Autowired
    //private ParkingSpotWebSocketHandler parkingSpotWebSocketHandler;
    @KafkaListener(topics = "parking-sensor-topic", groupId = "parking-sensor-group")
    public void consume(String message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ParkingSensor parkingSensor = objectMapper.readValue(message, ParkingSensor.class);


        System.out.println("Received parking sensor data: " + parkingSensor.toString());

        //parkingSpotWebSocketHandler.sendParkingSpotUpdate(message);
        ParkingSpot parkingSpot = parkingService.getParkingSpotBySensorId(parkingSensor.getSensorId());
        // Обновляем состояние парковочного места
        System.out.println(parkingSpot.toString());
        parkingSpot.setOccupied(parkingSensor.getIsOccupied());
        System.out.println("Data from postgre: "+ parkingSpot);
//        if(parkingSpot.getIsOccupied() == true) {
//            if (parkingSpot.getCurrentUserId() == null) {
//                parkingSpot.setStartTime(LocalDateTime.now());
//            }
//        }
//        else{
//            if(parkingSpot.getCurrentUserId() != null){
//                parkingService.stopParkingSession(parkingSpot.getId().toString());
//            }
//        }
        // Сохраняем обновленное состояние парковочного места
        parkingService.updateParkingSpotStatus(parkingSpot.getId(), parkingSensor.getIsOccupied());
        // Отправляем обновленное состояние парковочного места через веб-сокеты
        //parkingSpotWebSocketHandler.sendParkingSpotUpdate(objectMapper.writeValueAsString(parkingSpot));
    }
}

