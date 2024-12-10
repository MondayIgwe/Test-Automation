package utils;

import org.json.simple.JSONObject;

    public class Payload {



    public static JSONObject createPayload() {
        // Implement payload creation logic here
        JSONObject payload = new JSONObject();
        payload.put("name", "bruce");
        payload.put("job", "tester");
        System.out.println("Payload: " + payload);
        return payload;
    }
}
