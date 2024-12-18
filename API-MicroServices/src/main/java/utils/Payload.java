package utils;

import com.github.javafaker.Faker;
import org.json.simple.JSONObject;

public class Payload {
    private static final Faker faker = new Faker();

    public static String createPayload() {
        // Implement payload creation logic here
        JSONObject payload = new JSONObject();
        payload.put("name", faker.name().name());
        payload.put("job", faker.job().title());
        return payload.toJSONString();
    }

    public static String putPayload() {
        // Implement payload creation logic here
        JSONObject payload = new JSONObject();
        payload.put("name", faker.name().name());
        payload.put("job", faker.job().title());
        return payload.toJSONString();
    }

    public static String patchPayload() {
        // Implement payload creation logic here
        JSONObject payload = new JSONObject();
        payload.put("name", faker.name().name());
        payload.put("job", faker.job().title());
        return payload.toJSONString();
    }
}
