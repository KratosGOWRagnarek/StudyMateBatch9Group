package com.qa.studymate.api.tests;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.studymate.api.pojo.ApiBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.Map;


public class Login_api_steps extends ApiBase {


//    @Given("the base url is {string}")
//    public void the_base_url_is(String url) {
//        request = RestAssured.given().baseUri(url);
//    }
//
//    @Given("the endpoint is {string}")
//    public void the_endpoint_is(String endpoint) {
//        request = request.basePath(endpoint);
//    }
//
//    @Given("the origin header is set to {string}")
//    public void the_origin_header_is_set_to(String header) {
//        request.header("Origin", header);
//    }
//
//    @Given("the valid token is provided")
//    public void the_valid_token_is_provided() {
//        request.auth().oauth2(ConfigReader.readProperty("token"));
//    }
//
//    @Given("the request body contains key following fields")
//    public void the_request_body_contains_key_following_fields(DataTable dataTable) throws JsonProcessingException {
//        Map<String, String> fieldMap = new HashMap<>();
//
//        for (Map.Entry<String, String> entry : dataTable.asMap().entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//
//            if ("fromConfig".equalsIgnoreCase(value)) {
//                value = ConfigReader.readProperty(key);
//            }
//
//            fieldMap.put(key, value);
//        }
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonBody = mapper.writeValueAsString(fieldMap);
//
//        request = request.body(jsonBody).contentType("application/json");
//
//    }
//
//    @When("I send POST request")
//    public void i_send_post_request() {
//        response = request.post();
//    }
//
//    @Then("verify status code is {int}")
//    public void verify_status_code_is(Integer expectedStatusCode) {
//        response.then().statusCode(expectedStatusCode);
//    }
//
//    @Then("verify response body contains key {string} and value {string}")
//    public void verify_response_body_contains_key_and_value(String key, String value) {
//        String strResponse = response.asPrettyString();
//        Assert.assertTrue(strResponse.contains(key));
//        Assert.assertTrue(strResponse.contains(value));
//
//        System.out.println("Status Code: " + response.getStatusCode());
//        System.out.println("Body:" + response.getBody().asPrettyString());
//
//    }
}
