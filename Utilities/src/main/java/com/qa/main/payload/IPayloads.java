package com.qa.main.payload;

import java.util.HashMap;
import java.util.Map;

public interface IPayloads {

    class Payloads {
        final static String BEARER;

        static {
            BEARER = "Bearer";
            System.out.println("Payloads class loaded");
        }

        static void getHeaders(Map<String, String> map) {
            map.put("Authorization", BEARER.concat("YOUR_API_TOKEN"));
            map.put("Content-Type", "application/json");
        }

        public static Map<String, String> setPayload() {
            Map<String, String> payload = new HashMap<String, String>();
            payload.put("content-type", "application/json");

//            JsonObject jsonObject = new JsonObject();
//            jsonObject.add("name", JsonParser.parseString("John Doe"));
//            jsonObject.add("email", JsonParser.parseString("johndoe@example.com"));

            return payload;
        }
    }

}
