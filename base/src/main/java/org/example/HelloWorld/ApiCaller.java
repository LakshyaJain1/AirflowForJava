package org.example.HelloWorld;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ApiCaller {

    private OkHttpClient client;

    public ApiCaller() {
        this.client = new OkHttpClient();
    }

    public void makeApiCall() {
        // JSON payload for the request
        String json = "{\"models\":[{\"model_name\":\"name_match\", \"model_version\":2}], " +
                "\"features\": {\"source\":\"mr sumeeet agarwal\", \"target\":\"shri sumeet aggarrwaal\"}}";

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, json);

        // Replace 'asfasfasf' with the actual token
        Request request = new Request.Builder()
                .url("http://darwin-maas-orchestrator.internal.payufin.io/api/v1/get_multiple_model_version_scores")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Token", "asfasfasf")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                System.out.println("Response: " + responseBody);
                // Handle the response here
            } else {
                System.out.println("Error: " + response.code() + " - " + response.message());
                // Handle the error response here
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here
        }
    }
}


