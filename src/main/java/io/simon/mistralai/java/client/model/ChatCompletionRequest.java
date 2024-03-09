package io.simon.mistralai.java.client.model;

import io.simon.mistralai.java.client.exceptions.MissingRequiredField;

import java.util.List;

public class ChatCompletionRequest {
    private final String model;
    private final List<Message> messages;
    private final float temperature;
    private final float top_p;
    private final Integer max_tokens;
    private final boolean stream;
    private final boolean safe_prompt;
    private final Integer random_seed;

    private ChatCompletionRequest(Builder builder) {
        this.model = builder.model;
        this.messages = builder.messages;
        this.temperature = builder.temperature;
        this.top_p = builder.top_p;
        this.max_tokens = builder.max_tokens;
        this.stream = builder.stream;
        this.safe_prompt = builder.safe_prompt;
        this.random_seed = builder.random_seed;
    }

    public static class Builder {
        private String model;
        private List<Message> messages;
        private float temperature = 0.7f;
        private float top_p = 1;
        private Integer max_tokens;
        private boolean stream;
        private boolean safe_prompt;
        private Integer random_seed;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder messages(List<Message> messages) {
            this.messages = messages;
            return this;
        }

        public Builder temperature(float temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder top_p(float top_p) {
            this.top_p = top_p;
            return this;
        }

        public Builder max_tokens(Integer max_tokens) {
            this.max_tokens = max_tokens;
            return this;
        }

        public Builder stream(boolean stream) {
            this.stream = stream;
            return this;
        }

        public Builder safe_prompt(boolean safe_prompt) {
            this.safe_prompt = safe_prompt;
            return this;
        }

        public Builder random_seed(Integer random_seed) {
            this.random_seed = random_seed;
            return this;
        }

        public ChatCompletionRequest build() {
            checkRequiredFields();
            return new ChatCompletionRequest(this);
        }

        private void checkRequiredFields() {
            if (model == null) {
                throw new MissingRequiredField("model");
            }

            if (messages == null || messages.isEmpty()) {
                throw new MissingRequiredField("messages");
            }
        }
    }

    public String getModel() {
        return model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getTop_p() {
        return top_p;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public boolean isStream() {
        return stream;
    }

    public boolean isSafe_prompt() {
        return safe_prompt;
    }

    public Integer getRandom_seed() {
        return random_seed;
    }
}