package io.simon.mistralai.java.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.simon.mistralai.java.client.model.ChatCompletionRequest;
import io.simon.mistralai.java.client.model.ChatCompletionResponse;
import io.simon.mistralai.java.client.model.GetModelsResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MistralClient {
    private static final String USER_AGENT = "mistralai-java-client";
    private static final String BASE_URL = "https://api.mistral.ai/v1";
    private static final String MODELS_ENDPOINT = "/models";
    private static final String CHAT_COMPLETION_ENDPOINT = "/chat/completions";

    private String apiKey;

    private ObjectMapper mapper;

    private OkHttpClient httpClient;

    public MistralClient(String apiKey) {
        this.apiKey = apiKey;

        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    public GetModelsResponse getModels() {
        var request = new Request.Builder()
                .url(BASE_URL + MODELS_ENDPOINT)
                .header(Headers.AUTHORIZATION, "Bearer " + apiKey)
                .header(Headers.USER_AGENT, USER_AGENT)
                .build();

        return execute(request, GetModelsResponse.class);
    }

    public ChatCompletionResponse postChatCompletion(ChatCompletionRequest chatCompletion) throws JsonProcessingException {
        var body = RequestBody.create(mapper.writeValueAsBytes(chatCompletion), MediaType.get("application/json"));
        var request = new Request.Builder()
                .url(BASE_URL + CHAT_COMPLETION_ENDPOINT)
                .header(Headers.AUTHORIZATION, "Bearer " + apiKey)
                .header(Headers.USER_AGENT, USER_AGENT)
                .post(body)
                .build();

        return execute(request, ChatCompletionResponse.class);
    }

    private <T> T execute(Request request, Class<T> klass) {
        try (var response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            return mapper.readValue(response.body().bytes(), klass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
