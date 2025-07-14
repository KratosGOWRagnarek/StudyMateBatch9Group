package com.qa.studymate.api.pojo;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class ApiBase {

    protected static RequestSpecification request;
    protected static Response response;
     protected static JSONObject requestBody = new JSONObject();


}