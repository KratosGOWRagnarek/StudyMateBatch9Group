package com.qa.studymate.api.tests;

import com.qa.studymate.api.pojo.ApiBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.Map;


public class Student_api_steps extends ApiBase {


    @Given("the base url is {string}")
    public void the_base_url_is(String url) {
        request = RestAssured.given().baseUri(url);

    }

    @Given("the endpoint path is {string}")
    public void the_endpoint_path_is(String endpoint) {
        request = request.basePath(endpoint);
    }

    @Given("then request content type is {string}")
    public void then_request_content_type_is(String contentType) {
        request = request.contentType(contentType);

    }

    @Given("the origin header is set to {string}")
    public void the_origin_header_is_set_to(String header) {
        request.header("Origin", header);
    }

    @Given("the valid token is provided")
    public void the_valid_token_is_provided() {
        request.auth().oauth2(ConfigReader.readProperty("token"));

    }

    @Given("the request body contains following fields")
    public void the_request_body_contains_following_fields(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asMap();
        Map<String, String> data = dataTable.asMap();
        for (String key : data.keySet()) {
            requestBody.put(key, data.get(key));
        }
        request = request.body(requestBody.toString());

    }

    @When("i send a POST request")
    public void i_send_a_post_request() {
        response = request.post();

    }

    @Then("verify status code is {int}")
    public void verify_status_code_is(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("verify response body contains key {string} and value {string}")
    public void verify_response_body_contains_key_and_value(String key, String value) {
        String strResponse = response.asPrettyString();
        Assert.assertTrue(strResponse.contains(key));
        Assert.assertTrue(strResponse.contains(value));
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Body:" + response.getBody().asPrettyString());
    }

}
