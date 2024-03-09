package io.simon.mistralai.java.client.model;

public class ModelData {
    private String id;
    private String object;
    private int created;
    private String owned_by;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getOwned_by() {
        return owned_by;
    }

    public void setOwned_by(String owned_by) {
        this.owned_by = owned_by;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", owned_by='" + owned_by + '\'' +
                '}';
    }
}
