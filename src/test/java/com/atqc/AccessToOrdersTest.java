package com.atqc;

import com.sun.javafx.sg.prism.NGImageView;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import com.atqc.framework.Config;

public class AccessToOrdersTest extends RestAPIBaseTest{

    @Test
    @Description("Test for Access Endpoint")
    public void positiveGetStoreInventoryStatus (){
        given()
                .contentType("application/json")
                .baseUri("https://petstore.swagger.io/v2")
                .header("accept", "application/json")

        .when()
                .get("/store/inventory")
        .then()
                .statusCode(200)
                .body(notNullValue())
                .body("AVAILABLE", is(greaterThan(-1)))
                .body("sold", is(greaterThan(-1)))
                .body("string", is(greaterThan(-1)))
                .body("unavailable", is(greaterThan(-1)))
                .body("pending", is(greaterThan(-1)))
                .body("available", is(greaterThan(-1)));
    }
    
}
