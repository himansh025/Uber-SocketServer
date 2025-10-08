# Uber Socket Service

A Spring Boot microservice that handles **real-time ride notifications** and driver interactions in an Uber-like system.  
Uses **Kafka** for messaging, **WebSocket** (STOMP) for real-time communication, and integrates with the **Booking Service**.

---

## Features

- Publishes ride requests to drivers in real-time.
- Listens to driver responses for ride assignments.
- Integrates with Booking Service to update booking status.
- Kafka-based messaging for asynchronous communication.
- Supports STOMP WebSocket endpoints for driver notifications.

---

## REST Endpoints

| Endpoint                 | Method | Description                                 |
|--------------------------|--------|---------------------------------------------|
| `/api/socket/newride`    | POST   | Receives ride request from Booking Service |
| `/api/socket`            | GET    | Test Kafka publishing                       |

---

## WebSocket Endpoints

| Endpoint                         | Description                        |
|----------------------------------|------------------------------------|
| `/topic/rideRequest`              | Broadcast ride request to drivers  |
| `/app/riderResponse/{userId}`     | Driver response to a ride request  |

**Example STOMP Usage:**

```javascript
// Subscribe to ride requests
stompClient.subscribe('/topic/rideRequest', function(message) {
    console.log("New ride request: ", message.body);
});

// Send driver response
stompClient.send("/app/riderResponse/1", {}, JSON.stringify({
    bookingId: 123,
    response: "ACCEPTED"
}));

// Kafka Integration

    Producer

    Publishes messages to sample-topic:

    kafakProducerService.publishMessage("sample-topic", "hello world");

// Consumer

    Configured with ConcurrentKafkaListenerContainerFactory to listen to sample-topic.