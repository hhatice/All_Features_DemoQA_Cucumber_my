package com.kraft.services;

import com.github.javafaker.Faker;
import com.kraft.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Register {

    Response response;
    Faker faker=new Faker();
    public static String userID;
    public static String userName;
    public static String isbn;
    public static String token;
    public  static String password=ConfigurationReader.get("commonPassword");
    public void registerNewUser(){
        /**
        {
            "userName": "string",
                "password": "string"
        }
        */
        userName=faker.name().fullName();
        Map<String,Object> body=new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);


        response= RestAssured.given().contentType(ContentType.JSON)
                .and().log().all()
                .body(body)
                .post("/Account/v1/User").prettyPeek();


        userID=response.path("userID");
        System.out.println("userID = " + userID);

    }
    public void verifyRegister(){

        response.then().statusCode(201);

    }

    public void generateToken(){
        userName=ConfigurationReader.get("username");
        Map<String,Object>body=new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);
        response=RestAssured.given().contentType(ContentType.JSON)
                .when().log().all()
                .body(body)
                .post("/Account/v1/GenerateToken").prettyPeek();
        token=response.path("token");
        System.out.println("token = " + token);

    }
    public void verifyToken(){
        response.then().statusCode(201);
    }

    public void authorized(){
        userName=ConfigurationReader.get("username");
        Map<String,Object> body =new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);
        Map<String,Object> tokenBody=new HashMap<>();
        tokenBody.put("Authorization","Bearer "+ConfigurationReader.get("token"));

        response=RestAssured.given().contentType(ContentType.JSON)
                .when().log().all()
                .body(body)
                .and().headers(tokenBody)
                .post("/Account/v1/Authorized");

    }
    public void verifyAuthorized(){
        response.then().statusCode(200);
    }

    public void getUserById(){
        Map<String,Object> tokenBody=new HashMap<>();
        tokenBody.put("Authorization","Bearer "+ConfigurationReader.get("token"));
        response=RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",ConfigurationReader.get("userID"))
                .headers(tokenBody)
                .when().log().all()
                .get("/Account/v1/User/{id}").prettyPeek();
    }

    public void verifyUser(){
        response.then().statusCode(200);
    }


    public void allBooks(){
        response=RestAssured.given().contentType(ContentType.JSON)
                .when().log().all()
                .get("/BookStore/v1/Books").prettyPeek();
    }
    public void verifyAllBook(){
        response.then().statusCode(200);
    }

    public void addBook(){

        String body="{\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+ConfigurationReader.get("isbn5")+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Map<String,Object>tokenBody=new HashMap<>();
        tokenBody.put("Authorization", "Bearer "+ConfigurationReader.get("token"));
        response=RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenBody)
                .body(body)
                .and().log().all()
                .post("/BookStore/v1/Books");
    }
    public void verifyaddBook(){
        response.then().statusCode(201);
    }
    public void updatebook(){

        String body="{\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\",\n" +
                "  \"isbn\": \""+ConfigurationReader.get("isbn2")+"\"\n" +
                "}";

        Map<String,Object> token = new HashMap<>();
        token.put("Authorization","Bearer " + ConfigurationReader.get("token"));

        response= RestAssured.given().contentType(ContentType.JSON)
                .pathParam("isbn",ConfigurationReader.get("isbn5"))
                .headers(token)
                .body(body)
                .when().log().all()
                .put("/BookStore/v1/Books/{isbn}").prettyPeek();

    }
    public void verifyUpdateBook(){
        response.then().statusCode(200);
    }

    public void deleteBook(){

        String body="{\n" +
                "  \"isbn\": \""+ConfigurationReader.get("isbn2")+"\",\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\"\n" +
                "}";

        Map<String,Object>tokenBody=new HashMap<>();
        tokenBody.put("Authorization", "Bearer "+ConfigurationReader.get("token"));

        response=RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenBody)
                .body(body)
                .when().log().all()
                .delete("/BookStore/v1/Book").prettyPeek();

    }
    public void verifyDeleteBook(){
        response.then().statusCode(204);

    }
    public void AccountDelete(){
        Map<String,Object>tokenBody=new HashMap<>();
        tokenBody.put("Authorization", "Bearer "+ConfigurationReader.get("token"));
        response=RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenBody)
                .pathParam("id",ConfigurationReader.get("userID"))
                .and().log().all()
                .delete("/Account/v1/User/{id}").prettyPeek();

    }
    public void verifyAccountDelete(){
        response.then().statusCode(200);
    }

}
