package io.simon.mistralai.java.client.model;

import java.util.List;


public class GetModelsResponse {
    private String object;
    private List<ModelData> data;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<ModelData> getData() {
        return data;
    }

    public void setData(List<ModelData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GetModelsRequestBody{" +
                "object='" + object + '\'' +
                ", data=" + data +
                '}';
    }
}
