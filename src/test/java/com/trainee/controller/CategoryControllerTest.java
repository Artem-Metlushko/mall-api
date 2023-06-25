package com.trainee.controller;

import com.trainee.bean.Category;
import com.trainee.service.CategoryServiceRest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerTest {

    @LocalServerPort
    private int serverPort;
    @Autowired
    CategoryServiceRest categoryServiceRest;
    private Long id;
    private String name;
    private String description;
    private Integer productCount;
    private String image;
    private Double rating;
    private Category saveCategory;
    private Response response;

    @BeforeEach
    public void setUp() {
        RestAssured.port = serverPort;
        saveCategory = new Category();
        saveCategory.setDescription("test");
        saveCategory.setName("test");
        saveCategory.setImage("test");
        saveCategory.setRating(5.5D);
        saveCategory.setProductCount(5);
        response();

    }

    private void response() {
         response = given()
                .contentType("application/json")
                .body(saveCategory)
                .when()
                .post("/categories");

        id = Long.parseLong(response.then().extract().path("categoryId").toString());
        name = response.then().extract().path("name");
        image = response.then().extract().path("image");
        description = response.then().extract().path("description");
        rating = Double.parseDouble(response.then().extract().path("rating").toString());
        productCount = response.then().extract().path("productCount");
    }

    private void assertEqualsCheck() {
        assertEquals(name, saveCategory.getName());
        assertEquals(image, saveCategory.getImage());
        assertEquals(description, saveCategory.getDescription());
        assertEquals(productCount, saveCategory.getProductCount());
        assertEquals(rating, saveCategory.getRating());
    }

    @Test
    void whenRequestPost_thenOK() {
        given()
                .then()
                .statusCode(200)
                .contentType("application/json");
        assertEqualsCheck();
    }


    @Test
    void whenRequestGet_thenOK() {

        given()
                .when()
                .get("/categories/{id}", id)
                .then()
                .statusCode(200)
                .contentType("application/json");

        assertEqualsCheck();

    }

    @Test
    void whenRequestPut_thenOK() {
        Long categoryId = Long.parseLong(response.then().extract().path("categoryId").toString());


        Category updatedCategory = new Category();
        updatedCategory.setName("Updated Name");
        updatedCategory.setDescription("Updated Description");
        updatedCategory.setProductCount(10);
        updatedCategory.setImage("Updated Image");
        updatedCategory.setRating(4.5);

        given()
                .contentType("application/json")
                .body(updatedCategory)
                .when()
                .put("/categories/{categoryId}", categoryId)
                .then()
                .statusCode(200);

        Response getResponse = given()
                .when()
                .get("/categories/{categoryId}", categoryId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .response();

        assertEquals(updatedCategory.getName(), (getResponse.path("name")));
        assertEquals(updatedCategory.getDescription(), getResponse.path("description"));
        assertEquals(updatedCategory.getProductCount(), getResponse.path("productCount"));
        assertEquals(updatedCategory.getImage(), getResponse.path("image"));
        assertEquals(updatedCategory.getRating(), Double.parseDouble(getResponse.path("rating").toString()));
    }


    @Test
    void whenRequestDelete_thenOK() {
      id = Long.parseLong(response.then().extract().path("categoryId").toString());
        saveCategory.setCategoryId(id);

        given()
                .contentType("application/json")
                .body(saveCategory)
                .when()
                .delete("/categories")
                .then()
                .statusCode(200);

        given()
                .when()
                .get("/categories/{categoryId}", id)
                .then()
                .statusCode(200);

        Category deletedCategory = categoryServiceRest.findById(id);
        assertEquals(new Category(null, null, null, null, null, null), deletedCategory);
    }

    @Test
    void whenRequestGetAll_thenOK() {
        List<Category> categories = given()
                .when()
                .get("/categories")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .body()
                .jsonPath()
                .getList(".", Category.class);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

}
