package org.api.qa.helpers;

import java.util.HashMap;
import java.util.Map;

public interface IPayloads {

    class Payloads {

        static {
            System.out.println("Payloads class loaded");
        }
        static void getHeaders(Map<String, String> map){
            map.put("Authorization", "Bearer YOUR_API_TOKEN");
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
