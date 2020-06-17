package pl.pawel.app.domain.models;

public class CorsRecivedModel {
    private int id;
    private String name;

    public CorsRecivedModel() {
    }

    public CorsRecivedModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CorsRecivedModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
