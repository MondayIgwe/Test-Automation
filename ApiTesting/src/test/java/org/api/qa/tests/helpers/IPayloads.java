package org.api.qa.tests.helpers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface IPayloads {

    class Payloads {

        static {
            System.out.println("Payloads class loaded");
        }

        static void getHeaders(Map<String, String> map) {
            map.put("Authorization", "Bearer YOUR_API_TOKEN");
            map.put("Content-Type", "application/json");
        }

        public static Map<String, String> setPayload() {
            Map<String, String> payload = new HashMap<String, String>();
            payload.put("content-type", "application/json");

            JsonObject jsonObject = new JsonObject();
            jsonObject.add("name", JsonParser.parseString("John Doe"));
            jsonObject.add("email", JsonParser.parseString("johndoe@example.com"));

            return payload;
        }
    }
    public static String createBody() {
        return "{\n" +
                "  \"id\": 9223372036854775807,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
    }

    public static String ParseBody(byte[] body) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(body);
            return jsonNode.toPrettyString();
        } catch (JsonParseException jsonParseException) {
            jsonParseException.getStackTrace();
        }
        return null;
    }
}
