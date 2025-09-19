# ParkingBackend - Spring Boot (Minimal)

This is a minimal Spring Boot backend for a parking slot booking system with PhonePe payment placeholders.

## Features included
- Booking APIs
  - `POST /api/booking/slot` - create a parking slot
  - `GET /api/booking/slots` - list slots
  - `POST /api/booking/create` - create a booking (PENDING)
  - `GET /api/booking/{id}` - get booking

- Payment APIs
  - `POST /api/payment/create-order` - create payment order for a booking
  - `POST /api/payment/verify` - verify payment (placeholder)

- Webhook endpoint
  - `POST /api/webhook/phonepe` - placeholder webhook endpoint for PhonePe callbacks

## How to run
1. Install Java 17+ and Maven.
2. Update `src/main/resources/application.properties` for your MySQL database and PhonePe keys.
3. Build and run:
   ```bash
   mvn clean package
   java -jar target/ParkingBackend-0.0.1-SNAPSHOT.jar
   ```
4. For quick testing you can use the embedded H2 console (if you change datasource to h2).

## Integration notes (PhonePe)
This project contains placeholders for PhonePe order creation and verification. For production:
- Implement HTTPS server (SSL).
- Replace placeholder token/signature logic in `PaymentService` with PhonePe's official API calls and signature generation/verification as per PhonePe docs.
- Securely store merchant secret on server (do not embed in client).
- Verify webhook signatures before processing.

