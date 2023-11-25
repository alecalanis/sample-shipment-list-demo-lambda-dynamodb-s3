package dev.ancaghenade.shipmentlistdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import dev.ancaghenade.shipmentlistdemo.controller.ShipmentController;
import dev.ancaghenade.shipmentlistdemo.entity.Shipment;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
public class ShipmentControllerTest {

    @Autowired
    private ShipmentController shipmentController;

    @Value("${server.port}")
    private int serverPort;

    @Test
    public void testSaveUpdateShipmentWorks() {
        Shipment shipment = Shipment.builder().shipmentId("foobar").build();
        shipmentController.saveUpdateShipment(shipment);
    }

    @Test
    public void testSaveUpdateShipmentWorksViaRestTemplate() {
        // create a rest-assured test that does a http-post of a shipment on the api endpoint /api/shipment
        Shipment shipment = Shipment.builder().shipmentId("foobar").build();

        given()
            .contentType(ContentType.JSON)
            .body(shipment)
        .when()
            .port(serverPort)
            .post("/api/shipment")
        .then()
            .statusCode(200);

    }

}
