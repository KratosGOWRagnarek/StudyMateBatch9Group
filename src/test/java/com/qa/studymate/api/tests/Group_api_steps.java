package com.qa.studymate.api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.studymate.api.pojo.ApiBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.Map;


public class Group_api_steps extends ApiBase {







    @Given("the request body contains key following fields")
    public void the_request_body_contains_key_following_fields(DataTable dataTable) throws JsonProcessingException {
        Map<String, String> fieldMap = new HashMap<>();

        for (Map.Entry<String, String> entry : dataTable.asMap().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if ("fromConfig".equalsIgnoreCase(value)) {
                value = ConfigReader.readProperty(key);
            }

            fieldMap.put(key, value);
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(fieldMap);

        request = request.body(jsonBody).contentType("application/json");

    }

}
