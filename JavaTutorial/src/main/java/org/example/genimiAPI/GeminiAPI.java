package org.example.genimiAPI;

import com.google.genai.Client;
import com.google.genai.ResponseStream;
import com.google.genai.types.GenerateContentResponse;
import org.apache.http.HttpException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/*
    Google vertex and gemini API learning
    https://www.youtube.com/watch?v=MwCvHVC_yZY
    https://console.cloud.google.com/
 */
public class GeminiAPI {

    /**
     * The simplest way for instantiation. The client gets the API key from the
     * environment variable `GOOGLE_API_KEY` and use Gemini API when the environment
     * variable `GOOGLE_GENAI_USE_VERTEXAI` is not set or set to `false`.
     * Use Builder class for instantiation. Explicitly set the API key to use Gemini
     * Developer backend.
     **/

    public static void geminiAPIProcess(String query) throws HttpException, IOException {
        // Instantiate the client. The client by default uses the Gemini API. It gets
        // the API key from the environment variable `GOOGLE_API_KEY`.
        Client client = new Client();
        GenerateContentResponse response =
                client.models.generateContent(System.getenv("GEMINI_MODEL"), query, null);
        System.out.println(response.text());
        client.close();
    }

    public static void geminiAPIStreamContents(String query) throws HttpException, IOException {
        String apiKey = System.getenv("GOOGLE_API_KEY");
        if (apiKey == null) {
            throw new HttpException("Please set the environment variable GOOGLE_API_KEY");
        }
        Client client = Client.builder().apiKey(apiKey).build();

        CompletableFuture<GenerateContentResponse> responseFuture =
                client.async.models.generateContent(
                        System.getenv("GEMINI_MODEL"), query, null);

        responseFuture.thenAccept(
                        response -> {
                            System.out.println("Async response: " + response.text());
                        })
                .join();
        client.close();
    }
}
