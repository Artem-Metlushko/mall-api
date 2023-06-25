package com.trainee.controller;

import com.trainee.bean.Category;
import com.trainee.bean.Product;
import com.trainee.service.CategoryServiceRest;
import com.trainee.service.ProductServiceRest;
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
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    private int serverPort;
    @Autowired
    CategoryServiceRest categoryServiceRest;
    @Autowired
    ProductServiceRest productServiceRest;

    private Long categoryId;
    private Long productId;
    private String productName;
    private Double productPrice;
    private String productDescription;
    private Category saveCategory;
    private Category productCategory;
    private Product saveProduct;
    private Response response;

    @BeforeEach
    public void setUp() {
        RestAssured.port = serverPort;

        saveCategory = new Category();
        saveCategory.setName("Test Category");
        saveCategory.setDescription("Test Category Description");
        saveCategory.setImage("Test Category Image");
        saveCategory.setProductCount(10);
        saveCategory.setRating(4.5);


       Long categoryId = categoryServiceRest
                .save(saveCategory)
                .getCategoryId();

        saveProduct = new Product();
        saveProduct.setName("Test Product");
        saveProduct.setPrice(9.99);
        saveProduct.setDescription("Test Product Description");
        saveProduct.setCategory(saveCategory);
        response();

    }

    private void response() {
        response = given()
                .contentType("application/json")
                .body(saveProduct)
                .when()
                .post("/products");

        productId = Long.parseLong(response.then().extract().path("productId").toString());
        productName = response.then().extract().path("name");
        productPrice = Double.parseDouble(response.then().extract().path("price").toString());
        productDescription = response.then().extract().path("description");
        productCategory = parseCategory(response.then().extract().path("category"));

    }

    private Category parseCategory(Object object) {
        if (object instanceof Map<?, ?> jsonMap) {

            Long categoryId = Long.parseLong(jsonMap.get("categoryId").toString());
            String name = (String) jsonMap.get("name");
            String description = (String) jsonMap.get("description");
            Integer productCount = Integer.parseInt(jsonMap.get("productCount").toString());
            String image = (String) jsonMap.get("image");
            Double rating = Double.parseDouble(jsonMap.get("rating").toString());

            return new Category(categoryId, name, description, productCount, image, rating);
        }

        return new Category();
    }


    private void assertEqualsCheck() {
        assertEquals(productName, saveProduct.getName());
        assertEquals(productPrice, saveProduct.getPrice());
        assertEquals(productDescription, saveProduct.getDescription());
        assertEquals(saveCategory, saveProduct.getCategory());
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
                .get("/products/{productId}", productId)
                .then()
                .statusCode(200)
                .contentType("application/json");

        assertEqualsCheck();
    }

    @Test
    void whenRequestPut_thenOK() {
        Long productId = Long.parseLong(response.then().extract().path("productId").toString());

        Product updatedProduct = new Product();
        updatedProduct.setProductId(productId);
        updatedProduct.setName("Updated Product");
        updatedProduct.setPrice(19.99);
        updatedProduct.setDescription("Updated Product Description");
        updatedProduct.setCategory(saveCategory);

        given()
                .contentType("application/json")
                .body(updatedProduct)
                .when()
                .put("/products/{productId}", productId)
                .then()
                .statusCode(200);


        Response getResponse = given()
                .when()
                .get("/products/{productId}", productId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .response();

        assertEquals(updatedProduct.getName(), getResponse.path("name"));
        assertEquals(updatedProduct.getPrice(), Double.parseDouble(getResponse.path("price").toString()));
        assertEquals(updatedProduct.getDescription(), getResponse.path("description"));
        assertEquals(updatedProduct.getCategory(), parseCategory(getResponse.path("category")));
    }

    @Test
    void whenRequestDelete_thenOK() {
        productId = Long.parseLong(response.then().extract().path("productId").toString());
        saveProduct.setProductId(productId);

        given()
                .contentType("application/json")
                .body(saveProduct)
                .when()
                .delete("/products")
                .then()
                .statusCode(200);

        given()
                .when()
                .get("/products/{productId}", productId)
                .then()
                .statusCode(200);

        Product deletedProduct = productServiceRest.findById(productId);
        assertEquals(new Product(null, null, null, null, null), deletedProduct);
    }

    @Test
    void whenRequestGetAll_thenOK() {
        List<Product> products = given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .body()
                .jsonPath()
                .getList(".", Product.class);

        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

}
