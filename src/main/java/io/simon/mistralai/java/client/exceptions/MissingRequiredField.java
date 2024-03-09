package io.simon.mistralai.java.client.exceptions;

public class MissingRequiredField extends RuntimeException {
    public MissingRequiredField(String field) {
        super("Missing required field %s".formatted(field));
    }
}
